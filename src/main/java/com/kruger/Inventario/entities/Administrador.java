package com.kruger.Inventario.entities;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
// Pone el constructor por defecto
@NoArgsConstructor
public class Administrador extends Usuario {

    // Atributos
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
