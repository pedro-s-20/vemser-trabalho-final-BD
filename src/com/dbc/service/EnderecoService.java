package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Endereco;
import com.dbc.repository.EnderecoRepository;

public class EnderecoService implements Service<Integer, Endereco> {

    private EnderecoRepository enderecoRepository;

    public EnderecoService() {
        enderecoRepository = new EnderecoRepository();
    }

    @Override
    public void adicionar(Endereco endereco) {
        try {
            Endereco enderecoAdicionado = enderecoRepository.adicionar(endereco);
            System.out.println("endereço adicinado com sucesso! " + enderecoAdicionado);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = enderecoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id, Endereco endereco) {
        try {
            boolean conseguiuEditar = enderecoRepository.editar(id, endereco);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listar() {
        try {
            enderecoRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }


}
