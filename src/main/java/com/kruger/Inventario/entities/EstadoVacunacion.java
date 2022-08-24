package com.kruger.Inventario.entities;


import lombok.Getter;

@Getter
public enum EstadoVacunacion {

    VACUNADO("Vacunado"),
    NO_VACUNADO("No Vacunado");


    private final String nombre;

    EstadoVacunacion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoVacunacion{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
