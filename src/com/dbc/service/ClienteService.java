package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Cliente;
import com.dbc.model.Usuario;
import com.dbc.repository.ClienteRepository;
import com.dbc.repository.EnderecoRepository;

public class ClienteService implements Service<Integer, Cliente>{
    private ClienteRepository clienteRepository;

    public ClienteService(){
        clienteRepository = new ClienteRepository();
    }

    @Override
    public void adicionar(Cliente cliente) {
        try {
            if (validarEntradas(cliente)) {
                Cliente clienteAdicionado = clienteRepository.adicionar(cliente);
                System.out.println("Cliente adicinado com sucesso! " + clienteAdicionado);
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
            boolean conseguiuRemover = clienteRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id, Cliente cliente) {
        try {
            if (validarEntradas(cliente)){
                boolean conseguiuEditar = clienteRepository.editar(id, cliente);
                System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
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
    public boolean validarEntradas(Cliente cliente) {
        if (cliente.getIdUsuario() != null && cliente.getIdUsuario().toString().length() > 10){
            System.err.println("Erro em 'id_usuario': número de caracteres é superior à 10.");
            return false;
        }

        if (cliente.getIdConvenio() != null && cliente.getIdConvenio().toString().length() > 10){
            System.err.println("Erro em 'id_convenio': número de caracteres é superior à 10.");
            return false;
        }

        return true;
    }
}
