package com.kruger.Inventario.entities;

import com.kruger.Inventario.exceptions.UsuarioNotFoundException;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;


@Entity
@Inheritance (strategy = InheritanceType.JOINED)
// Pone el constructor por defecto
@NoArgsConstructor
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
    @NotEmpty (message = "El password del usuario es un campo obligatorio")
    private String password;


    public Usuario( @Positive (message = "La cedula del usuario es un campo obligatorio") Integer cedula,  @NotEmpty (message = "Los nombres del usuario es un campo obligatorio") String nombres, @NotEmpty (message = "Los apellidos del usuario es un campo obligatorio") String apellidos, @NotEmpty (message = "El email del usuario es un campo obligatorio") String email, @NotEmpty (message = "El password del usuario es un campo obligatorio") String password) {
        this.cedula = cedula;
        setNombres(nombres);
        setApellidos(apellidos);
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

    public void setNombres(String nombres) {
        // Validar nombres de usuario
       Boolean isString = Validaccion.validarString(nombres);
        System.out.println("valor devuelto para nombres  " + isString);


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
        System.out.println("valor devuelto para apellido  " + isString);

        if (isString) {
            this.apellidos = apellidos;
        }else {
            throw new UsuarioNotFoundException("Los apellidos del usuario " +
                    "no deben contener números o caracteres especiales");
        }
    }


}
