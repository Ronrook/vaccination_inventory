package com.kruger.Inventario.controllers;


import com.kruger.Inventario.entities.Usuario;
import com.kruger.Inventario.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/api/usuario")
    public String  saludo (){
        return "Saludos empleados";
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
