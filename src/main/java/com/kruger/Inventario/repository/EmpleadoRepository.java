package com.kruger.Inventario.repository;

import com.kruger.Inventario.entities.Empleado;
import com.kruger.Inventario.entities.EstadoVacunacion;
import com.kruger.Inventario.entities.TipoVacuna;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByVacuna (TipoVacuna vacuna);
    List<Empleado> findByEstadoVacunacion (EstadoVacunacion estadoVacunacion);
}
