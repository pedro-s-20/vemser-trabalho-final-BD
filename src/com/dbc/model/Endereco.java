package com.dbc.model;

public class Endereco {

    private Integer idEndereco, numero;
    private String estado, cidade, bairro, logradouro, cep, complemento;

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer id_endereco) {
        this.idEndereco = id_endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString(){
        return "Endereco{" +
                "idEndereco='" + getIdEndereco() + '\'' +
                ", logradouro='" + getLogradouro() + '\'' +
                ", numero='" + getNumero() + '\'' +
                ", bairro='" + getBairro() + '\'' +
                ", complemento='" + getComplemento() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                ", cep='" + getCep() + '\'' +
                "}";

    }

}
