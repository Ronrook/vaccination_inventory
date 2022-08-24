package com.kruger.Inventario.controllers;


import com.kruger.Inventario.entities.Usuario;
import com.kruger.Inventario.exceptions.UsuarioNotFoundException;
import com.kruger.Inventario.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }



    // Buscar un usuario por su id
    @GetMapping("api/usuario/{id}")
    public Usuario getUsuarioById (@PathVariable Long id ){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("No se encontró usuario con el id: " + id));
        return usuario;
    }



    // Crear un usuario
    @PostMapping("/api/usuario")
    public Usuario newUsuario ( @Valid @RequestBody Usuario usuario){

        Usuario usuario1 = usuarioRepository.findByCedula(usuario.getCedula());

        if (usuario1 != null) {
                if  (usuario1.getCedula().equals(usuario.getCedula())) {
                    throw new UsuarioNotFoundException("El usuario con número de cédula " + usuario.getCedula() +
                            " ya existe");
                }
        }
        return usuarioRepository.save(usuario);

    }

    @GetMapping ("/api/usuarios")
    public List<Usuario> allUsuarios() {
        return usuarioRepository.findAll();
    }
}
