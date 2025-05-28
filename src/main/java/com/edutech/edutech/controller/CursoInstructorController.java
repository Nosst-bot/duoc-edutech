package com.edutech.edutech.controller;

import com.edutech.edutech.model.CursoInstructor;
import com.edutech.edutech.service.CursoInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso-instructor")
public class CursoInstructorController {
    @Autowired
    private CursoInstructorService cursoInstructorService;

    @PostMapping
    public String asignarInstructor(@RequestBody CursoInstructor cursoInstructor) {
        return cursoInstructorService.asignarInstructor(cursoInstructor);
    }

    @GetMapping
    public List<CursoInstructor> listarAsignaciones() {
        return cursoInstructorService.listarAsignaciones();
    }
}
