package com.dbc.model;

import com.dbc.view.MenuAdministracao;
import com.dbc.view.MenuCliente;
import com.dbc.view.MenuMedico;

public enum TipoUsuario {

    ADMINISTRATIVO(1),
    MEDICO(2),
    CLIENTE(3);

    private Integer valor;

    TipoUsuario(Integer valor){
        this.valor = valor;
    }

    public Integer getValor(){
        return valor;
    }


    public void exibirMenu(){
        switch (getValor()) {
            case 1:
                MenuAdministracao.exibirMenu();
                break;
            case 2:
                MenuMedico.exibirMenu();
                break;
            case 3:
                MenuCliente.exibirMenu();
                break;
        }
    }



}
