package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.ClienteRepository;
import com.dbc.repository.EnderecoRepository;

public class ClienteService implements Service{
    private ClienteRepository clienteRepository;

    public ClienteService(){
        clienteRepository = new ClienteRepository();
    }
    @Override
    public void adicionar(Object object) {

    }

    @Override
    public void remover(Object id) {

    }

    @Override
    public void editar(Object id, Object object) {

    }

    @Override
    public void listar() {
        try {
            clienteRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validarEntradas(Object object) {
        return false;
    }
}
