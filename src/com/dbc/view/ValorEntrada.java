package com.dbc.view;

import com.dbc.exceptions.ValorDeEntradaException;

import java.math.BigDecimal;

public class ValorEntrada {

    // validar int
    public static void validarEntrada(int idUsuario, int valorMin, int valorMax) throws ValorDeEntradaException {

        if (idUsuario < valorMin || idUsuario > valorMax) {
            throw new ValorDeEntradaException("ID fora do permitido: " + idUsuario + ". ID permitido: " + valorMin + " < ID_USUARIO < " + valorMax);
        }

    }


    // validar String
    public static void validarEntrada(String string, int valorMin, int valorMax) throws ValorDeEntradaException {

        if (string.length() < valorMin || string.length() > valorMax) {
            throw new ValorDeEntradaException("Número de caracteres inserido incorreto: " + string.length() + ". O valor inserido precisa ter entre " + valorMin + " e " + valorMax + " caracteres.");
        }

    }

    //validar caracteres de quantitade específica
    public static void validarEntrada(String string, int valorPermitido) throws ValorDeEntradaException {

        if (string.length() != valorPermitido) {
            throw new ValorDeEntradaException("Número de caracteres inserido incorreto: " + string.length() + ". O número inserido precisa ter " + valorPermitido + " caracteres.");
        }

    }

    public static void validarEntrada(Double valor, int casasAntesDaVirgula, int casasAposDaVirgula) {
            BigDecimal valorDeEntrada = new BigDecimal(valor).setScale(2, BigDecimal.ROUND_UP);
            String valorComCasasDividas[] = valorDeEntrada.toString().split("\\.");

            if (valorComCasasDividas[0].length() > casasAntesDaVirgula || (valorComCasasDividas.length == 2 && valorComCasasDividas[1].length() > casasAposDaVirgula)) {
                throw new ValorDeEntradaException("Caracteres de número inserido incorreto: " + valorDeEntrada + ". O valor precisa ter "+ (casasAntesDaVirgula + casasAposDaVirgula) + " casas, sendo " + casasAposDaVirgula +" decimais.");
            }
        }




}