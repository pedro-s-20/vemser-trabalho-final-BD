package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Usuario;
import com.dbc.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

<<<<<<< HEAD
public class UsuarioService implements Service<Integer, Usuario> {
=======
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioService implements Service <Integer, Usuario>{
>>>>>>> b2f6331 (wip)
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }

    @Override
    public void adicionar(Usuario usuario) {
        try {
            Usuario usuarioAdicionado = usuarioRepository.adicionar(usuario);
            System.out.println("Usuário adicinado com sucesso! " + usuarioAdicionado);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = usuarioRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id, Usuario usuario) {
        try {
            boolean conseguiuEditar = usuarioRepository.editar(id, usuario);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listar() {
        try {
            usuarioRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
=======
    @Override
    public boolean validarEntradas(Usuario usuario) {
        if (usuario.getCpf() != null && usuario.getCpf().length() != 11){
            System.err.println("Erro em 'CPF': CPF inválido!");
            return false;
        }
        if (usuario.getNome() != null && usuario.getNome().length() > 255){
            System.err.println("Erro em 'Nome': número de caracteres superior a 255!");
            return false;
        }
        if (usuario.getEmail() != null && usuario.getEmail().length() > 300){
            System.err.println("Erro em 'Email': número de caracteres superior a 300!");
            return false;
        }
        if (usuario.getSenha() != null && usuario.getSenha().length() > 500){
            System.err.println("Erro em 'Senha': número de caracteres superior a 500!");
            return false;
        }
        if (usuario.getIdEndereco() != null && usuario.getIdEndereco().toString().length() > 10){
            System.err.println("Erro em 'id_endereco': número de caracteres superior ou inferior a 10.");
            return false;
        }
        if (usuario.getIdContato() != null && usuario.getIdContato().toString().length() > 10){
            System.err.println("Erro em 'id_contato': número de caracteres superior ou inferior a 10.");
            return false;
        }

        return true;
    }

    public boolean findAndAuth(String email, String password) {
        try {
            List<Usuario> tempList = usuarioRepository.listar().stream().filter(usuario -> usuario.getEmail().equals(email)
                    && usuario.getSenha().equals(password)).collect(Collectors.toList());
            return tempList.size() > 0;
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
            return false;
        }
    }
}
