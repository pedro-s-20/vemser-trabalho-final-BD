package com.dbc.model;

import java.util.Arrays;

public enum TipoContato {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoContato ofTipo(Integer tipo){ // 1
        return Arrays.stream(TipoContato.values()) //[RESIDENCIAL(1) , COMERCIAL(2)]
                .filter(tp -> tp.getTipo().equals(tipo)) //[RESIDENCIAL(1)]
                .findFirst() //optional => RESIDENCIAL(1)
                .get();//RESIDENCIAL(1)
    }
}
