package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Contato;
import com.dbc.model.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository implements Repositorio<Integer, Endereco>{

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
    public Endereco adicionar(Endereco endereco) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            endereco.setIdEndereco(proximoId);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO ENDERECO\n" +
                    "(id_endereco, estado, cidade, bairro, logradouro, cep, numero" );
            if (endereco.getComplemento() != null) {
                sql.append(", complemento");
            }

            sql.append(") values(?, ?, ?, ?, ?, ?, ?");
            if (endereco.getComplemento() != null) {
                sql.append(", ?");
            }
            sql.append(")");
            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 3;
            stmt.setInt(1, endereco.getIdEndereco());
            stmt.setString(2, endereco.getEstado());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getLogradouro());
            stmt.setString(6, endereco.getCep());
            stmt.setInt(7, endereco.getNumero());

            if (endereco.getComplemento() != null) {
                stmt.setString(8, endereco.getComplemento());
            }

            int res = stmt.executeUpdate();
            System.out.println("adicionarEndereco.res=" + res);
            return endereco;
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

            String sql = "DELETE FROM ENDERECO WHERE id_endereco = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerEnderecoPorId.res=" + res);

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
    public boolean editar(Integer id, Endereco endereco) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE ENDERECO SET ");

            if(endereco.getEstado() != null){
                sql.append(" estado = ?,");
            }
            if(endereco.getCidade() != null) {
                sql.append(" cidade = ?,");
            }
            if(endereco.getBairro() != null){
                sql.append(" bairro = ?,");
            }
            if(endereco.getLogradouro() != null){
                sql.append(" logradouro = ?,");
            }
            if(endereco.getCep() != null){
                sql.append(" cep = ?,");
            }
            if(endereco.getNumero() != null){
                sql.append(" numero = ?,");
            }
            if(endereco.getComplemento() != null){
                sql.append(" complemento = ?,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_endereco = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;

            if(endereco.getEstado() != null){
                stmt.setString(index++, endereco.getEstado());
            }
            if(endereco.getCidade() != null) {
                stmt.setString(index++, endereco.getCidade());
            }
            if(endereco.getBairro() != null){
                stmt.setString(index++, endereco.getBairro());
            }
            if(endereco.getLogradouro() != null){
                stmt.setString(index++, endereco.getLogradouro());
            }
            if(endereco.getCep() != null){
                stmt.setString(index++, endereco.getCep());
            }
            if(endereco.getNumero() != null){
                stmt.setInt(index++, endereco.getNumero());
            }
            if(endereco.getComplemento() != null){
                stmt.setString(index++, endereco.getComplemento());
            }

            stmt.setInt(index, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarEndereco.res=" + res);

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
        List<Endereco> enderecos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * " +
                    "       FROM ENDERECO E " ;

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Endereco endereco = getEnderecoFromResultSet(res);
                enderecos.add(endereco);
            }
            return enderecos;
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

    private Endereco getEnderecoFromResultSet(ResultSet res) throws SQLException {
        Endereco endereco = new Endereco();
        endereco.setIdEndereco(res.getInt("id_endereco"));
        endereco.setEstado(res.getString("estado"));
        endereco.setCidade(res.getString("cidade"));
        endereco.setBairro(res.getString("bairro"));
        endereco.setLogradouro(res.getString("logradouro"));
        endereco.setCep(res.getString("cep"));
        endereco.setNumero(res.getInt("numero"));
        endereco.setComplemento(res.getString("complemento"));

        return endereco;
    }

}
