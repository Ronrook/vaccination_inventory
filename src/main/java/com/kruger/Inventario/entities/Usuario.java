package com.kruger.Inventario.entities;

import com.kruger.Inventario.exceptions.UsuarioNotFoundException;
import com.kruger.Inventario.utilities.Validaccion;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.UUID;


@Entity
@Inheritance (strategy = InheritanceType.JOINED)
// Pone el constructor por defecto
@NoArgsConstructor
// Metodos getter por defecto
@Getter
public class Usuario {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "La cedula del usuario es un campo obligatorio")
    private Integer cedula;

    @NotEmpty (message = "Los nombres del usuario es un campo obligatorio")
    private String nombres;

    @NotEmpty (message = "Los apellidos del usuario es un campo obligatorio")
    private String apellidos;

    @NotEmpty (message = "El email del usuario es un campo obligatorio")
    @Email
    private String email;

    private String password = UUID.randomUUID().toString().toUpperCase().substring(0,6);


    public Usuario( @Positive (message = "La cedula del usuario es un campo obligatorio") Integer cedula,  @NotEmpty (message = "Los nombres del usuario es un campo obligatorio") String nombres, @NotEmpty (message = "Los apellidos del usuario es un campo obligatorio") String apellidos, @NotEmpty (message = "El email del usuario es un campo obligatorio") String email) {
        this.cedula = cedula;
        setNombres(nombres);
        setApellidos(apellidos);
        this.email = email;
    }


    public void setNombres(String nombres) {
        // Validar nombres de usuario
        Boolean isString = Validaccion.validarString(nombres);



        if (isString) {
            this.nombres = nombres;
        }else {
            throw new UsuarioNotFoundException("Los nombres del usuario " +
                    "no deben contener números o caracteres especiales");
        }
    }

    public void setApellidos(String apellidos) {
        // Validar apellidos de usuario
        Boolean isString = Validaccion.validarString(apellidos);


        if (isString) {
            this.apellidos = apellidos;
        }else {
            throw new UsuarioNotFoundException("Los apellidos del usuario " +
                    "no deben contener números o caracteres especiales");
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}