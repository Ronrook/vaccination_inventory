package com.kruger.Inventario.entities;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
//@PrimaryKeyJoinColumn( referencedColumnName = "id")
public class Administrador extends Usuario {

    // Atributos
    private Boolean isAdministrador;


    // Constructor


    public Administrador(Boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }

    public Administrador(Integer cedula, String nombres, String apellidos, String email, String password, Boolean isAdministrador) {
        super(cedula, nombres, apellidos, email, password);
        this.isAdministrador = isAdministrador;
    }

    public Boolean getAdministrador() {
        return isAdministrador;
    }
}
