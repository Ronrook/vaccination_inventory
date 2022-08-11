package com.kruger.Inventario.controllers;


import com.kruger.Inventario.entities.Empleado;
import com.kruger.Inventario.entities.Usuario;
import com.kruger.Inventario.exceptions.UsuarioNotFoundException;
import com.kruger.Inventario.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //@GetMapping("/api/usuario")
    //public String  saludo (){
        //return "Saludos empleados";
    //}


    // Buscar un usuario por su id
    @GetMapping("api/usuario/{id}")
    public Usuario getUsuarioById (@PathVariable Long id ){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("No se encontró usuario con el id: " + id));
        return usuario;
    }



    @PostMapping("/api/usuario")
    public Usuario newUsuario (@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);

    }

    @GetMapping ("/api/usuarios")
    public List<Usuario> allUsuarios() {
        return usuarioRepository.findAll();
    }
}
