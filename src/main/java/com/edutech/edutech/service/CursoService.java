package com.edutech.edutech.service;

import com.edutech.edutech.model.Curso;
import com.edutech.edutech.model.Contenido;
import com.edutech.edutech.repository.CursoRepository;
import com.edutech.edutech.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//Kevin Peña

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Curso> allCursos() {
        return cursoRepository.findAll();
    }

    public List<Curso> buscarPorId(int id) {
        List<Curso> list = new ArrayList<>();
        if(cursoRepository.findById(id).isPresent()) {
            list.add(cursoRepository.findById(id).get());
        }

        return list;
    }

    public List<Curso> buscarPorSigla(String sigla) {
        List<Curso> list = new ArrayList<>();
        if(cursoRepository.findBySigla(sigla) != null) {
            list.add(cursoRepository.findBySigla(sigla));
        }

        return list;
    }

    public String crearCurso(Curso newCurso) {
        if(cursoRepository.findBySigla(newCurso.getSigla()) != null) {
            return "El curso con esa sigla ya existe.";
        }

        cursoRepository.save(newCurso);
        return "Curso creado correctamente.";
    }

    public String asignarContenido(int idCurso, int idContenido) {
        if (!contenidoRepository.existsById(idContenido)) {
            return "El contenido ingresado no existe.";
        }
        if (!cursoRepository.existsById(idCurso)) {
            return "El curso ingresado no existe.";
        }
        Curso curso = cursoRepository.findById(idCurso).get();
        Contenido contenido = contenidoRepository.findById(idContenido).get();
        if (curso.getContenidos().contains(contenido)) {
            return "El contenido ya está asignado a este curso.";
        }
        curso.getContenidos().add(contenido);
        cursoRepository.save(curso);
        return "Contenido asignado al curso correctamente.";
    }
}
