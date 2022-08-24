package com.kruger.Inventario.entities;

import lombok.Getter;

@Getter
public enum TipoVacuna {
    SPUTNIK("Sputnik"),
    ASTRAZENECA("AstraZeneca"),
    PFIZER("Pfizer"),
    JHONSON_JHONSON("Jhonson&Jhonson");

    private final String nombre;

    TipoVacuna(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoVacuna{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}