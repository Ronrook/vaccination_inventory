package com.kruger.Inventario.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
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

    // Constructor
    public Usuario(Long id, Integer cedula, String nombres, String apellidos, String email, String password) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }
}
