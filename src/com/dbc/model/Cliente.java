package com.dbc.model;

import java.util.ArrayList;

public class Cliente{
    private Integer idConvenio, idCliente, idUsuario;

    public Integer getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Cliente {" + super.toString() + "," +
                " id_convenio = '"+getIdConvenio()+"'}";
    }
}
