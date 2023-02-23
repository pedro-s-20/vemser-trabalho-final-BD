package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Contato;
import com.dbc.model.Endereco;
import com.dbc.repository.ContatoRepository;

public class ContatoService implements Service<Integer, Contato>{
    private ContatoRepository contatoRepository;

    public ContatoService() {
        contatoRepository = new ContatoRepository();
    }

    @Override
    // criação de um objeto
    public void adicionar(Contato contato) {
        try {
            if (validarEntradas(contato)) {
                Contato contatoAdicionado = contatoRepository.adicionar(contato);
                System.out.println("contato adicinado com sucesso! " + contatoAdicionado);
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
            if (validarEntradas(contato)){
                boolean conseguiuEditar = contatoRepository.editar(id, contato);
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
            contatoRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validarEntradas(Contato contato) {
        if (!(contato.getTelefone1().length() <= 11 && contato.getTelefone1().length() >= 10)){
            System.err.println("Erro em 'Telefone 1'! Número inválido!");
            return false;
        }
        if (contato.getTelefone2() != null &&
                !(contato.getTelefone2().length() <= 11 && contato.getTelefone2().length() >= 10)){
            System.err.println("Erro em 'Telefone 2'! Número inválido!");
            return false;
        }
        if (contato.getTelefone3() != null &&
                !(contato.getTelefone3().length() <= 11 && contato.getTelefone3().length() >= 10)){
            System.err.println("Erro em 'Telefone 3'!  inválido!");
            return false;
        }

        return true;
    }

//    public void listarContatoPorCodigoDaPessoa(Integer idPessoa) {
//        try {
//            contatoRepository.listarContatosPorPessoa(idPessoa).forEach(System.out::println);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
}
