package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Especialidade;
import com.dbc.repository.EspecialidadeRepository;

public class EspecialidadeService implements Service<Integer, Especialidade> {
    private EspecialidadeRepository especialidadeRepository;

    public EspecialidadeService() {
        especialidadeRepository = new EspecialidadeRepository();
    }

    @Override
    // criação de um objeto
    public void adicionar(Especialidade especialidade) {
        try {
            if (validarEntradas(especialidade)) {
                Especialidade especialidadeAdicionado = especialidadeRepository.adicionar(especialidade);
                System.out.println("contato adicinado com sucesso! " + especialidadeAdicionado);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    // remoção
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = especialidadeRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    // atualização de um objeto
    public void editar(Integer id, Especialidade especialidade) {
        try {
            if (validarEntradas(especialidade)){
                boolean conseguiuEditar = especialidadeRepository.editar(id, especialidade);
                System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    // leitura
    public void listar() {
        try {
            especialidadeRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public boolean validarEntradas(Especialidade especialidade) {
        if (especialidade.getNome() != null &&
                !(especialidade.getNome().length() <= 60)){
            System.err.println("Nome excedeu os 60 caracteres.");
            return false;
        }

        return true;
    }
}
