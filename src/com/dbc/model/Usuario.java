package com.dbc.model;

import java.util.ArrayList;

public class Usuario {
    private Integer idUsuario, idEndereco, idContato;
    private String cpf, email, nome, senha;

    private TipoUsuario tipoUsuario;

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

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

    public void setIdEndereco(Integer idEndereco) {
        if (idEndereco == 0) {
            this.idEndereco = null;
        }  else {
            this.idEndereco = idEndereco;
        }
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        if (idContato == 0) {
            this.idContato = null;
        }  else {
            this.idContato = idContato;
        }
    }

    @Override
    public String toString() {
        return  "Usuario {id_usuario = '" + getIdUsuario() +
                "', nome = '" +
                getNome()+"', " +
                "cpf = '" +
                getCpf()+"', " +
                "email = '" +
                getEmail()+ "', " +
                "idEndereco = '" +
                getIdEndereco() +
                "', idContato = '" +
                getIdContato() + "'" +
                ", tipoUsuario = '" +
                getTipoUsuario() +
                "'}";
    }
}
