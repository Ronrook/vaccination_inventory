package com.kruger.Inventario.services;

import com.kruger.Inventario.entities.Empleado;
import com.kruger.Inventario.entities.EstadoVacunacion;
import com.kruger.Inventario.entities.TipoVacuna;
import com.kruger.Inventario.exceptions.UsuarioNotFoundException;
import com.kruger.Inventario.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpmeadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public Empleado getEmpleado(Long empleadoId){
        return empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new UsuarioNotFoundException("No se encontró empleado con el id: " + empleadoId));
    }

    @Override
    public List<Empleado>  getAll (){
        return empleadoRepository.findAll();
    }

    @Override
    public List<Empleado> getAllVaccinated(EstadoVacunacion estadoVacunacion) {
        return empleadoRepository.findByEstadoVacunacion(estadoVacunacion);

    }

    @Override
    public List<Empleado> getAllByVaccine(TipoVacuna tipoVacuna){
        return empleadoRepository.findByVacuna(tipoVacuna);
    }
}
