package com.kruger.Inventario.controllers;


import com.kruger.Inventario.entities.*;
import com.kruger.Inventario.exceptions.UsuarioNotFoundException;
import com.kruger.Inventario.repository.EmpleadoRepository;
import com.kruger.Inventario.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    // Atributos
    private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;

    // Constructor
    public EmpleadoController(UsuarioRepository usuarioRepository, EmpleadoRepository empleadoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empleadoRepository = empleadoRepository;
    }


    // Buscar un empleado por su id
    @GetMapping("/{id}")
    @ApiOperation("Buscar un empleado por clave primaria id Long")
    public Empleado getEmpleadoById (@ApiParam("Clave primaria tipo Long") @PathVariable Long id ){
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("No se encontró empleado con el id: " + id));

    }

    // Crear un empleado
    @PostMapping()
    @ApiOperation("Crear un nuevo empleado")
    public ResponseEntity<Empleado> newEmpleado (@Valid @RequestBody Empleado empleado){

        Usuario usuario = usuarioRepository.findByCedula(empleado.getCedula());

        if (usuario != null) {
            if  (usuario.getCedula().equals(empleado.getCedula())) {
                throw new UsuarioNotFoundException("El usuario con número de cédula " + empleado.getCedula() +
                        " ya existe");
            }
        }
        Empleado empleadoSave=  empleadoRepository.save(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoSave);

    }



    // Método que elimina un empleado
    @PutMapping ("/actualizar/")
    @ApiOperation("Actualizar un empleado")
    public ResponseEntity<Object> updateEmpleado(@RequestBody Empleado empleado) {

        Optional<Empleado> empleadoData = empleadoRepository.findById(empleado.getId());

        if (empleadoData.isPresent()){
            Empleado _empleado = empleadoData.get();
            _empleado.setNombres(empleado.getNombres());
            _empleado.setApellidos(empleado.getApellidos());
            _empleado.setEmail(empleado.getEmail());
            _empleado.setEmail(empleado.getEmail());
            _empleado.setFechaNacimiento(empleado.getFechaNacimiento());
            _empleado.setDireccionDomicilio(empleado.getDireccionDomicilio());
            _empleado.setTelefono(empleado.getTelefono());
            _empleado.setEstadoVacunacion(empleado.getEstadoVacunacion());
            _empleado.setVacuna(empleado.getVacuna());
            _empleado.setFechaVacunacion(empleado.getFechaVacunacion());
            _empleado.setNumeroDosis(empleado.getNumeroDosis());

            Empleado empleadoUpadate=  empleadoRepository.save(_empleado);
            return  ResponseEntity.status(HttpStatus.OK).body(empleadoUpadate);
        }
        return  ResponseEntity.status(HttpStatus.OK).body(false);
    }


    // Método que elimina un empleado
    @DeleteMapping ("/eliminar/{userId}")
    @ApiOperation("Eliminar un empleado por su id")
    public ResponseEntity<Object> deleteEmpleado(@ApiParam("Parámetro de eliminación Tipo Long") @PathVariable Long userId) {
        empleadoRepository.deleteById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }



    /**
     * Develve el listado de todos los empleados
     * @return Listado de empleados
     **/
    @GetMapping ()
    @ApiOperation("Recuperar listado de todos los empleados")
    public List<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

    // Método que devuelve una lista filtrada según el estado de vacunación
    @GetMapping ("/estado/{estadoVacunacion}")
    @ApiOperation("Filtrar listado de empleados por estado de vacunación")
    public List<Empleado> findAllVacunados(@ApiParam("Parámetro de busqueda Tipo EstadoVacunacion") @PathVariable EstadoVacunacion estadoVacunacion) {
        return empleadoRepository.findByEstadoVacunacion(estadoVacunacion);
    }

    // Método que devuelve una lista filtrada según el tipo de vacuna
    @GetMapping ("/vacuna/{vacuna}")
    @ApiOperation("Filtrar listado de empleados por tipo de vacuna")
    public List<Empleado> findAllVacuna(@ApiParam("Parámetro de busqueda Tipo vacuna") @PathVariable TipoVacuna vacuna) {
        return empleadoRepository.findByVacuna(vacuna);
    }




}
