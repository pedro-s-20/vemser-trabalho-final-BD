package com.dbc.model;

import java.util.ArrayList;

public abstract class Usuario {
    private Integer idUsuario;
    private String cpf;
    private String email;
    private String nome;
    private String senha;
    private Integer idEndereco;
    private Integer idContato;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer id_endereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer id_contato) {
        this.idContato = idContato;
    }

}
