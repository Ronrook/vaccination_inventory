package com.kruger.Inventario.repository;

import com.kruger.Inventario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail (String email);
    Usuario findByCedula (Integer cedula);
    // Verificar si ya existe usuario con esa cedula
    boolean existsByCedula(int cedula);
}
