package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements Repositorio<Integer, Cliente> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Cliente adicionar(Cliente cliente) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Cliente cliente) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List listar() throws BancoDeDadosException {
        List<Cliente> clietes = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT u.*, c.* " +
                    "       FROM USUARIO u INNER JOIN CLIENTE C ON (c.id_usuario = u.id_usuario)  " ;

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
        cliente.setIdUsuario(res.getInt("id_usuario"));
//        cliente.setNome(res.getString("nome"));
//        cliente.setCpf(res.getString("cpf"));
//        cliente.setEmail(res.getString("email"));
//        cliente.setSenha(res.getString("senha"));
//        cliente.setIdEndereco(res.getInt("id_endereco"));
//        cliente.setIdContato(res.getInt("id_contato"));

        cliente.setIdCliente(res.getInt("id_cliente"));
        cliente.setIdConvenio(res.getInt("id_convenio"));
        return cliente;
    }
}
