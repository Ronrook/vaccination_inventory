package com.kruger.Inventario.repository;

import com.kruger.Inventario.entities.Empleado;
import com.kruger.Inventario.entities.EstadoVacunacion;
import com.kruger.Inventario.entities.TipoVacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Query Methods
    List<Empleado> findByVacuna (TipoVacuna vacuna);
    List<Empleado> findByEstadoVacunacion (EstadoVacunacion estadoVacunacion);
}
