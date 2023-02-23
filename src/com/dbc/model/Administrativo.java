package com.dbc.model;

public class Administrativo extends Usuario{

    private String codigoDoAdministrativo;
    public Administrativo(){
    }

    public String getCodigoDoAdministrativo() {
        return codigoDoAdministrativo;
    }

    public void setCodigoDoAdministrativo(String codigoDoAdministrativo) {
        this.codigoDoAdministrativo = codigoDoAdministrativo;
    }
}
