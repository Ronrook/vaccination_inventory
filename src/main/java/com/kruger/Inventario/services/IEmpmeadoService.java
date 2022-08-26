package com.kruger.Inventario.services;

import com.kruger.Inventario.entities.Empleado;
import com.kruger.Inventario.entities.EstadoVacunacion;
import com.kruger.Inventario.entities.TipoVacuna;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IEmpmeadoService {


    Empleado getEmpleado(Long empleadoId);
    Empleado save(Empleado empleado);
    Empleado update(Empleado empleado);
    void delete(Long userId);
    List<Empleado> getAll();
    List<Empleado> getAllVaccinated(EstadoVacunacion estadoVacunacion);
    List<Empleado> getAllByVaccine(TipoVacuna tipoVacuna);

}
