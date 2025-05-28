package com.edutech.edutech.service;

import com.edutech.edutech.model.Curso;
import com.edutech.edutech.model.Instructor;
import com.edutech.edutech.repository.CursoRepository;
import com.edutech.edutech.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Kevin PEÑA
@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public String guardarInstructor(Instructor instructor) {
        if (instructorRepository.findByRut(instructor.getRut()) != null) {
            return "Ya existe un instructor con ese RUT.";
        }
        instructorRepository.save(instructor);
        return "Instructor almacenado correctamente.";
    }

    public List<Instructor> listarInstructores() {
        return instructorRepository.findAll();
    }

    public String eliminarInstructorPorId(int id) {
        if (!instructorRepository.existsById(id)) {
            return "No se encontró un instructor con ese ID.";
        }
        instructorRepository.deleteById(id);
        return "Instructor eliminado correctamente.";
    }

    public String asignarCurso(int idInstructor, int idCurso) {
        if (!instructorRepository.existsById(idInstructor)) {
            return "El instructor ingresado no existe.";
        }
        if (!cursoRepository.existsById(idCurso)) {
            return "El curso ingresado no existe.";
        }
        Instructor instructor = instructorRepository.findById(idInstructor).get();
        Curso curso = cursoRepository.findById(idCurso).get();
        if (instructor.getCursos().contains(curso)) {
            return "El curso ya está asignado a este instructor.";
        }
        instructor.getCursos().add(curso);
        instructorRepository.save(instructor);
        return "Curso asignado al instructor correctamente.";
    }
}
