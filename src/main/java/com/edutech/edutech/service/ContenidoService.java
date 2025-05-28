package com.edutech.edutech.service;

import com.edutech.edutech.model.Contenido;
import com.edutech.edutech.model.Curso;
import com.edutech.edutech.repository.ContenidoRepository;
import com.edutech.edutech.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Contenido> listarContenidos() {
        return  contenidoRepository.findAll();
    }


    public String crearContenido(Contenido newContenido) {
        if (contenidoRepository.findByTitulo(newContenido.getTitulo()) != null) {
            return "Ya existe un contenido con ese titulo.";
        }

        contenidoRepository.save(newContenido);
        return "Contenido creado con exito";
    }

    public String asignarCurso(int idCurso, int idContenido) {
        if (!contenidoRepository.existsById(idContenido)) {
            return "El contenido ingresado no existe.";
        } else if (!cursoRepository.existsById(idCurso)) {
            return "El curso ingresado no existe.";
        } else {
        Curso curso = cursoRepository.findById(idCurso).get();
        }

    }
}
