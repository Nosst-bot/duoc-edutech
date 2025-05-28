package com.edutech.edutech.service;

import com.edutech.edutech.model.CursoInstructor;
import com.edutech.edutech.repository.CursoInstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoInstructorService {
    @Autowired
    private CursoInstructorRepository cursoInstructorRepository;

    public String asignarInstructor(CursoInstructor cursoInstructor) {
        cursoInstructorRepository.save(cursoInstructor);
        return "Instructor asignado al curso correctamente.";
    }

    public List<CursoInstructor> listarAsignaciones() {
        return cursoInstructorRepository.findAll();
    }
}
