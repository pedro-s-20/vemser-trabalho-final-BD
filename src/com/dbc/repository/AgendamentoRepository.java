package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Agendamento;
import com.dbc.model.Cliente;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoRepository implements Repositorio<Integer, Agendamento>{


    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        try {
            String sql = "SELECT seq_agendamento.nextval mysequence from DUAL";
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
    public Agendamento adicionar(Agendamento agendamento) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            agendamento.setIdAgendamento(proximoId);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO AGENDAMENTO\n" +
                    "(id_agendamento, id_medico, id_cliente, data_horario,");

            if (agendamento.getTratamento()!= null) {
                sql.append(" tratamento,");
            }
            if (agendamento.getExame()!= null) {
                sql.append(" exame,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(") values(?, ?, ?, ?,");
            if (agendamento.getTratamento() != null) {
                sql.append(" ?,");
            }
            if (agendamento.getExame() != null) {
                sql.append(" ?,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(")");
            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 5;
            stmt.setInt(1, agendamento.getIdAgendamento());
            stmt.setInt(2, agendamento.getIdMedico());
            stmt.setInt(3, agendamento.getIdCliente());

            Date dataAgendamentoSQL = (Date) Date.from(agendamento.getDataHorario().atZone(ZoneId.systemDefault()).toInstant());
            stmt.setDate(4, dataAgendamentoSQL);

            if (agendamento.getTratamento() != null) {
                stmt.setString(index++, agendamento.getTratamento());
            }
            if (agendamento.getExame() != null) {
                stmt.setString(index, agendamento.getExame());
            }

            int res = stmt.executeUpdate();
            System.out.println("adicionarAgendamento.res=" + res);
            return agendamento;
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

            String sql = "DELETE FROM AGENDAMENTO WHERE ID_AGENDAMENTO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerAgendamentoPorId.res=" + res);

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
    public boolean editar(Integer id, Agendamento agendamento) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE AGENDAMENTO SET");

            if (agendamento.getIdCliente()!= null) {
                sql.append(" id_cliente = ?,");
            }
            if (agendamento.getIdMedico() != null) {
                sql.append(" id_medico = ?,");
            }
            if (agendamento.getTratamento() != null) {
                sql.append(" tratamento = ?,");
            }
            if (agendamento.getExame() != null) {
                sql.append(" exame = ?,");
            }
            if (agendamento.getDataHorario() != null) {
                sql.append(" data_horario = ?,");
            }

            sql.deleteCharAt(sql.length() - 1); //remove o ultimo ','
            sql.append(" where id_agendamento = ?");
            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int index = 1;

            if (agendamento.getIdCliente()!= null) {
                stmt.setInt(index++, agendamento.getIdCliente());
            }
            if (agendamento.getIdMedico()!= null) {
                stmt.setInt(index++, agendamento.getIdMedico());
            }
            if (agendamento.getTratamento()!= null) {
                stmt.setString(index++, agendamento.getTratamento());
            }
            if (agendamento.getExame()!= null) {
                stmt.setString(index++, agendamento.getExame());
            }
            if (agendamento.getDataHorario()!= null) {
                Date dataAgendamentoSQL = (Date) Date.from(agendamento.getDataHorario().atZone(ZoneId.systemDefault()).toInstant());
                stmt.setDate(index++, dataAgendamentoSQL);
            }

            stmt.setInt(index, id);
            int res = stmt.executeUpdate();
            System.out.println("editarAgendamento.res=" + res);
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
    public List<Agendamento> listar() throws BancoDeDadosException {
        List<Agendamento> agendamentos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * " +
                    "       FROM  AGENDAMENTO A " ;

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Agendamento agendamento = getAgendamentoFromResultSet(res);
                agendamentos.add(agendamento);
            }
            return agendamentos;
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


    private Agendamento getAgendamentoFromResultSet(ResultSet res) throws SQLException {
        Agendamento agendamento = new Agendamento();
        agendamento.setIdAgendamento(res.getInt("id_agendamento"));
        agendamento.setIdCliente(res.getInt("id_cliente"));
        agendamento.setIdMedico(res.getInt("id_medico"));
        agendamento.setTratamento(res.getString("tratamento"));
        agendamento.setExame(res.getString("exame"));
        agendamento.setDataHorario(res.getTimestamp("data_horario").toLocalDateTime());

        return agendamento;
    }

}
