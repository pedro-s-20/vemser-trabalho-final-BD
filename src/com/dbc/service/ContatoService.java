package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Contato;
import com.dbc.repository.ContatoRepository;

public class ContatoService implements Service<Integer, Contato> {
    private ContatoRepository contatoRepository;

    public ContatoService() {
        contatoRepository = new ContatoRepository();
    }

    @Override
    // criação de um objeto
    public void adicionar(Contato contato) {
        try {
            Contato contatoAdicionado = contatoRepository.adicionar(contato);
            System.out.println("contato adicinado com sucesso! " + contatoAdicionado);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    // remoção
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = contatoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    // atualização de um objeto
    public void editar(Integer id, Contato contato) {
        try {
            boolean conseguiuEditar = contatoRepository.editar(id, contato);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    // leitura
    public void listar() {
        try {
            contatoRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

}
