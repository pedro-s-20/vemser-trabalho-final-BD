package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Medico;
import com.dbc.repository.MedicoRepository;

public class MedicoService implements Service<Integer, Medico> {
    private MedicoRepository medicoRepository;

    public MedicoService() {
        medicoRepository = new MedicoRepository();
    }

    @Override
    public void adicionar(Medico medico) {
        try {
            Medico medicoAdicionado = medicoRepository.adicionar(medico);
            System.out.println("Cliente adicinado com sucesso! " + medicoAdicionado);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = medicoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id, Medico medico) {
        try {
            boolean conseguiuEditar = medicoRepository.editar(id, medico);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listar() {
        try {
            medicoRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

}
