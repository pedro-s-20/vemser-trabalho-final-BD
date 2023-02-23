package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Endereco;
import com.dbc.repository.EnderecoRepository;

public class EnderecoService implements Service<Integer, Endereco>{

    private EnderecoRepository enderecoRepository;

    public EnderecoService(){
        enderecoRepository = new EnderecoRepository();
    }

    @Override
    public void adicionar(Endereco endereco) {
        try {
            if (validarEntradas(endereco)) {
                Endereco enderecoAdicionado = enderecoRepository.adicionar(endereco);
                System.out.println("endereço adicinado com sucesso! " + enderecoAdicionado);
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
            boolean conseguiuRemover = enderecoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id, Endereco endereco) {
        try {
            if (validarEntradas(endereco)){
                boolean conseguiuEditar = enderecoRepository.editar(id, endereco);
                System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
            }
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

    @Override
    public boolean validarEntradas(Endereco endereco) {
        if (endereco.getEstado().length() > 40){
            System.err.println("Erro em 'Estado': número de caracteres superior a 40.");
            return false;
        }
        if (endereco.getCidade().length() > 100){
            System.err.println("Erro em 'Cidade': número de caracteres superior a 100.");
            return false;
        }
        if (endereco.getBairro().length() > 50){
            System.err.println("Erro em 'Bairro': número de caracteres superior a 50.");
            return false;
        }
        if (endereco.getLogradouro().length() > 255){
            System.err.println("Erro em 'Logradouro': número de caracteres superior a 255.");
            return false;
        }
        if (endereco.getCep().length() != 9){
            System.err.println("Erro em 'CEP': número de caracteres superior ou inferior a 9.");
            return false;
        }
        if (endereco.getNumero().toString().length() > 8){
            System.err.println("Erro em 'Número': número de caracteres superior a 8.");
            return false;
        }
        if (endereco.getLogradouro().length() > 100){
            System.err.println("Erro em 'Logradouro': número de caracteres superior a 100.");
            return false;
        }
        if (endereco.getComplemento().length() > 100){
            System.err.println("Erro em 'Complemento': número de caracteres superior a 100.");
            return false;
        }

        return true;
    }

}
