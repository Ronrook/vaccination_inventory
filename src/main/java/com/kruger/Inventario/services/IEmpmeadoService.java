package com.kruger.Inventario.services;

import com.kruger.Inventario.entities.Empleado;
import com.kruger.Inventario.entities.EstadoVacunacion;
import com.kruger.Inventario.entities.TipoVacuna;

import java.util.List;

public interface IEmpmeadoService {

    Empleado getEmpleado(Long empleadoId);
    List<Empleado> getAll();
    List<Empleado> getAllVaccinated(EstadoVacunacion estadoVacunacion);
    List<Empleado> getAllByVaccine(TipoVacuna tipoVacuna);
}
