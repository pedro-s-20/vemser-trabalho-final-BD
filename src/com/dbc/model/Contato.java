package com.dbc.model;

public class Contato {
    private Integer idContato;
    private String telefone1, telefone2, telefone3;


    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", telefone1='" + getTelefone1() + '\'' +
                ", telefone2='" + getTelefone2() + '\'' +
                ", telefone3='" + getTelefone3() + '\'' +
                '}';
    }
}
