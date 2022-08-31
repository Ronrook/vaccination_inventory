package com.kruger.Inventario.services;

import com.kruger.Inventario.entities.Empleado;
import com.kruger.Inventario.entities.EstadoVacunacion;
import com.kruger.Inventario.entities.TipoVacuna;
import com.kruger.Inventario.exceptions.UsuarioNotFoundException;
import com.kruger.Inventario.repository.EmpleadoRepository;
import com.kruger.Inventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;



    @Override
    public Empleado getEmpleado(Long empleadoId){
        return empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new UsuarioNotFoundException("No se encontró empleado con el id: " + empleadoId));
    }

    public Empleado save(Empleado empleado){

        // Verificar que número de cédula no exista
        if(usuarioRepository.existsByCedula(empleado.getCedula())){
            throw new UsuarioNotFoundException("El usuario con número de cédula " + empleado.getCedula() +
                    " ya existe");

        }

        return empleadoRepository.save(empleado);

    }


    @Override
    public Empleado update(Empleado empleado) {

        Optional<Empleado> empleadoData = empleadoRepository.findById(empleado.getId());

        if (!empleadoData.isPresent()) {
            throw new UsuarioNotFoundException("El usuario no se encuentra registrado");
        }

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

        return empleadoRepository.save(_empleado);
    }

    @Override
    public void delete(Long userId) {
        empleadoRepository.deleteById(userId);
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
