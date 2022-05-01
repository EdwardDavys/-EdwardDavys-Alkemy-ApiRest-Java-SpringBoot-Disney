package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.repository;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existByNombreUsuario(String nombreUsuario);
    boolean existByEmail(String email);

}
