package com.kruger.Inventario.controllers;


import com.kruger.Inventario.entities.Empleado;
import com.kruger.Inventario.entities.Usuario;
import com.kruger.Inventario.entities.Validaccion;
import com.kruger.Inventario.exceptions.UsuarioNotFoundException;
import com.kruger.Inventario.repository.EmpleadoRepository;
import com.kruger.Inventario.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController {

    private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoController(UsuarioRepository usuarioRepository, EmpleadoRepository empleadoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empleadoRepository = empleadoRepository;
    }


    // Buscar un empleado por su id
    @GetMapping("/api/empleado/{id}")
    public Empleado getUsuarioById (@PathVariable Long id ){
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("No se encontró empleado con el id: " + id));
        return empleado;

    }

    // Crear un empleado
    @PostMapping("/api/empleado")
    public Empleado newEmpleado (@Valid @RequestBody Empleado empleado){

        Usuario usuario = usuarioRepository.findByCedula(empleado.getCedula());

        if (usuario != null) {
            if  (usuario.getCedula().equals(empleado.getCedula())) {
                throw new UsuarioNotFoundException("El usuario con número de cédula " + empleado.getCedula() +
                        " ya existe");
            }
        }
        return empleadoRepository.save(empleado);

    }


    /**
     *
     * @return
     */

    @GetMapping ("/api/empleados")
    public List<Empleado> findUsuarios() {
        return empleadoRepository.findAll();
    }


}
