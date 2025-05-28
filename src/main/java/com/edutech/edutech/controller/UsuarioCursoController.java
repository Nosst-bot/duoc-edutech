package com.edutech.edutech.controller;

import com.edutech.edutech.model.UsuarioCurso;
import com.edutech.edutech.service.UsuarioCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario-curso")
public class UsuarioCursoController {
    @Autowired
    private UsuarioCursoService usuarioCursoService;

    @PostMapping
    public String inscribirUsuario(@RequestBody UsuarioCurso usuarioCurso) {
        return usuarioCursoService.inscribirUsuario(usuarioCurso);
    }

    @GetMapping
    public List<UsuarioCurso> listarInscripciones() {
        return usuarioCursoService.listarInscripciones();
    }
}
