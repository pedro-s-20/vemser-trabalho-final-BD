package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Agendamento;
import com.dbc.repository.AgendamentoRepository;

public class AgendamentoService implements Service<Integer, Agendamento>{

    private AgendamentoRepository agendamentoRepository;

    public AgendamentoService() {
        this.agendamentoRepository = new AgendamentoRepository();
    }



    @Override
    public void adicionar(Agendamento agendamento) {
        try {
            if (validarEntradas(agendamento)) {
                Agendamento agendamentoAdicionado = agendamentoRepository.adicionar(agendamento);
                System.out.println("Agendamento adicinado com sucesso! " + agendamentoAdicionado);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = agendamentoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id, Agendamento agendamento) {
        try {
            if (validarEntradas(agendamento)){
                boolean conseguiuEditar = agendamentoRepository.editar(id, agendamento);
                System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listar() {
        try {
            agendamentoRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }


    public boolean validarEntradas(Agendamento agendamento) {
        if (agendamento.getIdCliente() != null && agendamento.getIdCliente().toString().length() > 10){
            System.err.println("Erro em 'id_cliente': número de caracteres é superior à 10.");
            return false;
        }
        if (agendamento.getIdMedico() != null && agendamento.getIdMedico().toString().length() > 10){
            System.err.println("Erro em 'id_medico': número de caracteres é superior à 10.");
            return false;
        }
        if (agendamento.getTratamento() != null && agendamento.getTratamento().length() > 40){
            System.err.println("Erro em 'id_cliente': número de caracteres é superior à 40.");
            return false;
        }
        if (agendamento.getExame() != null && agendamento.getExame().length() > 40){
            System.err.println("Erro em 'id_medico': número de caracteres é superior à 40.");
            return false;
        }

        return true;
    }
}
