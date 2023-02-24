package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Endereco;
import com.dbc.model.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoRepository implements Repositorio<Integer, Medico>{
    @Override
    public Integer getProximoId(Connection connection) throws BancoDeDadosException {
        try {
            String sql = "SELECT seq_endereco.nextval mysequence from DUAL";
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            if (res.next()) {
                return res.getInt("mysequence");
            }

            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        }
    }

    @Override
    public Medico adicionar(Medico medico) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            medico.setIdMedico(proximoId);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO MEDICO\n" +
                    "(id_medico, crm, id_especialidade, id_usuario) VALUES (?, ?, ?, ?)");

            PreparedStatement stmt = con.prepareStatement(sql.toString());


            stmt.setInt(1, medico.getIdMedico());
            stmt.setString(2, medico.getCrm());
            stmt.setInt(3, medico.getIdEspecialidade());
            stmt.setInt(4, medico.getIdUsuario());

            int res = stmt.executeUpdate();
            System.out.println("adicionarMedico.res=" + res);
            return medico;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM MEDICO WHERE id_medico = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerMedicoPorId.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Medico medico) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE MEDICO SET ");

            if(medico.getCrm() != null){
                sql.append(" crm = ?,");
            }
            if(medico.getIdEspecialidade() != null){
                sql.append(" id_especialidade = ?,");
            }
            if(medico.getIdUsuario() != null){
                sql.append(" id_usuario = ?,");
            }


            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_medico = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;

            if(medico.getCrm() != null){
                stmt.setString(index++, medico.getCpf());
            }
            if(medico.getIdEspecialidade() != null){
                stmt.setInt(index++, medico.getIdEspecialidade());
            }
            if(medico.getIdUsuario() != null){
                stmt.setInt(index++, medico.getIdUsuario());
            }


            stmt.setInt(index, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarMedico.res=" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List listar() throws BancoDeDadosException {
        List<Medico> listaMedico = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * " +
                    "       FROM MEDICO M " ;

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Medico medico = getMedicoFromResultSet(res);
                listaMedico.add(medico);
            }
            return listaMedico;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Medico getMedicoFromResultSet(ResultSet res) throws SQLException {
        Medico medico = new Medico();
        medico.setIdMedico(res.getInt("id_medico"));
        medico.setCrm(res.getString("crm"));
        medico.setIdEspecialidade(res.getInt("id_especialidade"));
        medico.setIdUsuario(res.getInt("id_usuario"));

        return medico;
    }
}
