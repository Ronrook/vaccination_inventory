package com.kruger.Inventario.entities;

public class Validaccion {

    public static Boolean validarString(String datos) {
        return datos.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
    }

}
