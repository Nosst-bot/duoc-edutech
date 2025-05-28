package com.edutech.edutech.service;

import com.edutech.edutech.model.Instructor;
import com.edutech.edutech.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Kevin PEÑA
@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

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
}
