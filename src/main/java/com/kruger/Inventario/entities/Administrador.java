package com.kruger.Inventario.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
// Pone el constructor por defecto
@NoArgsConstructor
// Metodos getter por defecto
@Getter
public class Administrador extends Usuario {

    // Atributos
    @Column(name = "es_administrador")
    private Boolean isAdministrador;


    // Constructor

    public Administrador(Integer cedula, String nombres, String apellidos, String email, String password, Boolean isAdministrador) {
        super(cedula, nombres, apellidos, email, password);
        this.isAdministrador = isAdministrador;
    }

    public Boolean getAdministrador() {
        return isAdministrador;
    }
}
