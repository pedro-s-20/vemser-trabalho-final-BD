package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements Repositorio<Integer, Cliente> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT seq_cliente.nextval mysequence from DUAL";
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
    public Cliente adicionar(Cliente cliente) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            cliente.setIdCliente(proximoId);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO CLIENTE\n" +
                    "(id_cliente, id_usuario,");


            if (cliente.getIdConvenio()!= null) {
                sql.append(" id_convenio,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(") values(?, ?,");
            if (cliente.getIdConvenio() != null) {
                sql.append(" ?,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(")");
            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, cliente.getIdCliente());
            stmt.setInt(2, cliente.getIdUsuario());

            if (cliente.getIdConvenio() != null) {
                stmt.setInt(3, cliente.getIdConvenio());
            }

            int res = stmt.executeUpdate();
            System.out.println("adicionarCliente.res=" + res);
            return cliente;
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

            String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerConvenioPorId.res=" + res);

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
    public boolean editar(Integer id, Cliente cliente) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CLIENTE SET");

            if (cliente.getIdUsuario()!= null) {
                sql.append(" id_usuario = ?,");
            }
            if (cliente.getIdConvenio() != null) {
                sql.append(" id_convenio = ?,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" where id_cliente = ?");
            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;
            if (cliente.getIdUsuario()!= null) {
                stmt.setInt(index++, cliente.getIdUsuario());
            }
            if (cliente.getIdConvenio()!= null) {
                stmt.setInt(index++, cliente.getIdConvenio());
            }

            stmt.setInt(index, id);
            int res = stmt.executeUpdate();
            System.out.println("editarCliente.res=" + res);
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
        List<Cliente> clietes = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * " +
                    "       FROM  CLIENTE C " ;

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Cliente cliente = getClienteFromResultSet(res);
                clietes.add(cliente);
            }
            return clietes;
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

    private Cliente getClienteFromResultSet(ResultSet res) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(res.getInt("id_cliente"));
        cliente.setIdUsuario(res.getInt("id_usuario"));
        cliente.setIdConvenio(res.getInt("id_convenio"));
        return cliente;
    }
}
