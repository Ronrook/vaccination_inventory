package com.kruger.Inventario.entities;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty("Solo acepta datos de tipo Enum EstadoVacunacion")
    @Enumerated(EnumType.STRING)
    @Column (name = "estado_vacunacion")
    private EstadoVacunacion estadoVacunacion;

    @ApiModelProperty("Solo acepta datos de tipo Enum TipoVacuna")
    @Enumerated(EnumType.STRING)
    private TipoVacuna vacuna;


    @Column (name = "fecha_vacunacion")
    private LocalDate fechaVacunacion;

    @Column (name = "numero_dosis")
    private Integer numeroDosis;

    // Constructor

    public Empleado(Integer cedula, String nombres, String apellidos, String email, LocalDate fechaNacimiento, String direccionDomicilio, String telefono, EstadoVacunacion estadoVacunacion, TipoVacuna vacuna, LocalDate fechaVacunacion, Integer numeroDosis) {
        super(cedula, nombres, apellidos, email);
        this.fechaNacimiento = fechaNacimiento;
        this.direccionDomicilio = direccionDomicilio;
        this.telefono = telefono;
        this.estadoVacunacion = estadoVacunacion;
        this.vacuna = vacuna;
        this.fechaVacunacion = fechaVacunacion;
        this.numeroDosis = numeroDosis;
    }

}