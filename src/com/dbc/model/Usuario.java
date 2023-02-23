package com.dbc.model;

import java.util.ArrayList;

public abstract class Usuario {
    private int idUsuario;
    private String nome;
    private Endereco endereco;
    private Contato contato;

    public int getIdUsuario() {
        return idUsuario;
    }

    private String telefone;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }


}
