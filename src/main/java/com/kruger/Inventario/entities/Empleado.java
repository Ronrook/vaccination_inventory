package com.kruger.Inventario.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;

@Entity
// Pone el constructor por defecto
@NoArgsConstructor
// Metodos getter y setter por defecto
@Getter
@Setter
public class Empleado extends Usuario {

    // Atributos
    @Column (name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column (name = "direccion_domicilio")
    private String direccionDomicilio;

    private String telefono;

    @Column (name = "es_vacunado")
    private Boolean isVacunado;

    @Enumerated(EnumType.STRING)
    private TipoVacuna vacuna = TipoVacuna.NO_VACUNADO;

    @Column (name = "fecha_vacunacion")
    private LocalDate fechaVacunacion;

    @Column (name = "numero_dosis")
    private Integer numeroDosis;

    // Constructor

    public Empleado(Integer cedula, String nombres, String apellidos, String email, String password, LocalDate fechaNacimiento, String direccionDomicilio, String telefono, Boolean isVacunado, TipoVacuna vacuna, LocalDate fechaVacunacion, Integer numeroDosis) {
        super(cedula, nombres, apellidos, email, password);
        this.fechaNacimiento = fechaNacimiento;
        this.direccionDomicilio = direccionDomicilio;
        this.telefono = telefono;
        this.isVacunado = isVacunado;
        this.vacuna = vacuna;
        this.fechaVacunacion = fechaVacunacion;
        this.numeroDosis = numeroDosis;
    }

}
