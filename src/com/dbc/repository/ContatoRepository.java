package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoRepository implements Repositorio<Integer, Contato> {

    @Override
    public Integer getProximoId(Connection connection) throws BancoDeDadosException {
        try {
            String sql = "SELECT seq_contato.nextval mysequence from DUAL";
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
    public Contato adicionar(Contato contato) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            contato.setIdContato(proximoId);

//            String sql = ?, ?, ?, ?)\n";

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO CONTATO\n" +
                    "(id_contato, telefone1," );



            if (contato.getTelefone2() != null) {
                sql.append(" telefone 2,");
            }
            if (contato.getTelefone3() != null) {
                sql.append(" telefone 3,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(") values(?, ?,");
            if (contato.getTelefone2() != null) {
                sql.append("?,");
            }
            if (contato.getTelefone3() != null) {
                sql.append("?,");
            }
            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(")");
            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 3;
            stmt.setInt(1, contato.getIdContato());
            stmt.setString(2, contato.getTelefone1());

            if (contato.getTelefone2() != null) {
                stmt.setString(index++, contato.getTelefone2());
            }
            if (contato.getTelefone3() != null) {
                stmt.setString(index++, contato.getTelefone3());
            }

            int res = stmt.executeUpdate();
            System.out.println("adicionarContato.res=" + res);
            return contato;
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

            String sql = "DELETE FROM CONTATO WHERE ID_CONTATO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerContatoPorId.res=" + res);

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
    public boolean editar(Integer id, Contato contato) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE contato SET \n");

            if (contato.getTelefone1() != null) {
                sql.append(" telefone1 = ?,");
            }
            if (contato.getTelefone2() != null) {
                sql.append(" telefone2 = ?,");
            }
            if (contato.getTelefone3() != null) {
                sql.append(" telefone3 = ?,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" WHERE id_contato = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;

            if (contato.getTelefone1() != null) {
                stmt.setString(index++, contato.getTelefone1());
            }
            if (contato.getTelefone2() != null) {
                stmt.setString(index++, contato.getTelefone2());
            }
            if (contato.getTelefone3() != null) {
                stmt.setString(index++, contato.getTelefone3());
            }

            stmt.setInt(index++, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarContato.res=" + res);

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
    public List<Contato> listar() throws BancoDeDadosException {
        List<Contato> contatos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * " +
                    "       FROM CONTATO C " ;

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Contato contato = getContatoFromResultSet(res);
                contatos.add(contato);
            }
            return contatos;
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

//    public List<Contato> listarContatosPorPessoa(Integer idPessoa) throws BancoDeDadosException {
//        List<Contato> contatos = new ArrayList<>();
//        Connection con = null;
//        try {
//            con = ConexaoBancoDeDados.getConnection();
//
//
//            String sql = "SELECT C.*, " +
//                    "            P.NOME AS NOME_PESSOA " +
//                    "       FROM CONTATO C " +
//                    " INNER JOIN PESSOA P ON (P.ID_PESSOA = C.ID_PESSOA) " +
//                    "      WHERE C.ID_PESSOA = ? ";
//
//            // Executa-se a consulta
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setInt(1, idPessoa);
//
//            ResultSet res = stmt.executeQuery();
//
//            while (res.next()) {
//                Contato contato = getContatoFromResultSet(res);
//                contatos.add(contato);
//            }
//            return contatos;
//        } catch (SQLException e) {
//            throw new BancoDeDadosException(e.getCause());
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private Contato getContatoFromResultSet(ResultSet res) throws SQLException {
        Contato contato = new Contato();
        contato.setIdContato(res.getInt("id_Contato"));
        contato.setTelefone1(res.getString("telefone1"));
        contato.setTelefone2(res.getString("telefone2"));
        contato.setTelefone3(res.getString("telefone3"));
        return contato;
    }
}
