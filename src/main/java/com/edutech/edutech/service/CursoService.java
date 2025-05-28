package com.edutech.edutech.service;

import com.edutech.edutech.model.Curso;
import com.edutech.edutech.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//Kevin Peña

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

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
}
