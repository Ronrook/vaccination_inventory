package com.kruger.Inventario.controllers;


import com.kruger.Inventario.entities.*;
import com.kruger.Inventario.services.EmpleadoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    // Atributos
    @Autowired
    private EmpleadoService empleadoService;




    // Buscar un empleado por su id
    @GetMapping("/{empleadoId}")
    @ApiOperation("Buscar un empleado por clave primaria id Long")
    public Empleado getEmpleadoById (@ApiParam("Clave primaria tipo Long") @PathVariable Long empleadoId ){
        return empleadoService.getEmpleado(empleadoId);

    }

    // Crear un empleado
    @PostMapping()
    @ApiOperation("Crear un nuevo empleado")
    public ResponseEntity<Empleado> newEmpleado (@Valid @RequestBody Empleado empleado){
        Empleado empleadoSave = empleadoService.save(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoSave);

    }


    // Método que elimina un empleado
    @PutMapping ("/actualizar/")
    @ApiOperation("Actualizar un empleado")
    public ResponseEntity<Object> updateEmpleado(@RequestBody Empleado empleado) {

        Empleado empleadoUpadate = empleadoService.update(empleado);
        return  ResponseEntity.status(HttpStatus.OK).body(empleadoUpadate);

    }


    // Método que elimina un empleado
    @DeleteMapping ("/eliminar/{userId}")
    @ApiOperation("Eliminar un empleado por su id")
    public ResponseEntity<Object> deleteEmpleado(@ApiParam("Parámetro de eliminación Tipo Long") @PathVariable Long userId) {
        empleadoService.delete(userId);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
    

    /**
     * Develve el listado de todos los empleados
     * @return Listado de empleados
     **/
    @GetMapping ()
    @ApiOperation("Recuperar listado de todos los empleados")
    public List<Empleado> findAllEmpleados() {
        return empleadoService.getAll();
    }

    // Método que devuelve una lista filtrada según el estado de vacunación
    @GetMapping ("/estado/{estadoVacunacion}")
    @ApiOperation("Filtrar listado de empleados por estado de vacunación")
    public List<Empleado> findAllVacunados(@ApiParam("Parámetro de busqueda Tipo EstadoVacunacion") @PathVariable EstadoVacunacion estadoVacunacion) {
        return empleadoService.getAllVaccinated (estadoVacunacion);
    }

    // Método que devuelve una lista filtrada según el tipo de vacuna
    @GetMapping ("/vacuna/{vacuna}")
    @ApiOperation("Filtrar listado de empleados por tipo de vacuna")
    public List<Empleado> findAllVacuna(@ApiParam("Parámetro de busqueda Tipo vacuna") @PathVariable TipoVacuna vacuna) {
        return empleadoService.getAllByVaccine(vacuna);
    }




}
