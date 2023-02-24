package com.dbc.model;

import java.util.ArrayList;

public class Cliente extends Usuario{
    private Convenio convenio;

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    @Override
    public String toString() {
        return "Cliente {" + super.toString() + " }";
    }
}
