package com.kruger.Inventario.utilities;

public class Validaccion {

    public static Boolean validarString(String datos) {
        return datos.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
    }

}
