package com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.controller;


import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.dto.Mensaje;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.dto.JwtDto;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.dto.LoginUsuario;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.dto.NuevoUsuario;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.entity.Rol;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.entity.Usuario;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.enums.RolNombre;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.jwt.JwtProvider;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.service.RolService;
import com.eduardo.sanchez.alkemyjavaspringbootdisneyapi.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    PasswordEncoder  passwordEncoder;

    @Autowired
    AuthenticationManager  authenticationManager;
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario =
        new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jtw = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jtw,userDetails.getUsername(),userDetails.getAuthorities());
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }
}
