package com.kruger.Inventario.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Inheritance (strategy = InheritanceType.JOINED)
//@NoArgsConstructor
public class Usuario {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cedula;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;

    public Usuario(){

    }

    public Usuario(Integer cedula, String nombres, String apellidos, String email, String password) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Integer getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
