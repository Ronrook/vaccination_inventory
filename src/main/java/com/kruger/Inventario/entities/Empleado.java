package com.kruger.Inventario.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
// Pone el constructor por defecto
@NoArgsConstructor
public class Empleado extends Usuario {

    // Atributos
    private Date fechaNacimiento;
    private String direccionDomicilio;
    private String telefono;
    private Boolean isVacunado;

    // Constructor


    public Empleado(Integer cedula, String nombres, String apellidos, String email, String password, Date fechaNacimiento, String direccionDomicilio, String telefono, Boolean isVacunado) {
        super(cedula, nombres, apellidos, email, password);
        this.fechaNacimiento = fechaNacimiento;
        this.direccionDomicilio = direccionDomicilio;
        this.telefono = telefono;
        this.isVacunado = isVacunado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public Boolean getIsVacunado() {
        return isVacunado;
    }
}
