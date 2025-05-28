package com.edutech.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.dto.AsignacionPreferenciaDTO;
import com.edutech.edutech.service.UsuarioPreferenciaService;

@RestController
@RequestMapping("/usuario-preferencia")
public class UsuarioPreferenciaController {
@Autowired
    private UsuarioPreferenciaService usuarioPreferenciaService;

   @PostMapping
    public String asignarPreferencia(@RequestBody AsignacionPreferenciaDTO dto) {
        return usuarioPreferenciaService.asignarPreferencia(dto.getMail(), dto.getIdPreferencia());
    }
}
