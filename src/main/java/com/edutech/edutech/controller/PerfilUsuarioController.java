package com.edutech.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.dto.AsignacionPerfilDTO;
import com.edutech.edutech.service.PerfilUsuarioService;

@RestController
@RequestMapping("/perfil-usuario")
public class PerfilUsuarioController {
 @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @PostMapping
    public String asignarPerfil(@RequestBody AsignacionPerfilDTO dto) {
        return perfilUsuarioService.asignarPerfil(dto.getMail(), dto.getTag());
    }
}
