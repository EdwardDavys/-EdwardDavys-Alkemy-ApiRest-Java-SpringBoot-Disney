package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.service;


import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.entity.Rol;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.enums.RolNombre;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
