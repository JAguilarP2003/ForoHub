package com.aluracursos.challenges.foroHub.controller;

import com.aluracursos.challenges.foroHub.domain.usuarios.dto.AuthUsuario;
import com.aluracursos.challenges.foroHub.domain.usuarios.Usuario;
import com.aluracursos.challenges.foroHub.infra.security.dto.JWToken;
import com.aluracursos.challenges.foroHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacion")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid AuthUsuario authUsuario) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(authUsuario.login(), authUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authenticationToken);
        var JWToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JWToken(JWToken));
    }
}
