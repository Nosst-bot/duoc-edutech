package com.edutech.edutech.service;

import com.edutech.edutech.model.UsuarioCurso;
import com.edutech.edutech.repository.UsuarioCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioCursoService {
    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    public String inscribirUsuario(UsuarioCurso usuarioCurso) {
        usuarioCursoRepository.save(usuarioCurso);
        return "Usuario inscrito en el curso correctamente.";
    }

    public List<UsuarioCurso> listarInscripciones() {
        return usuarioCursoRepository.findAll();
    }
}
