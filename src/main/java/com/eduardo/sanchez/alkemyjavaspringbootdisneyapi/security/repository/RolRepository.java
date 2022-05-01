package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.repository;

import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.entity.Rol;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol,Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
