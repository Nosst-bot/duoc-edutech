package com.edutech.edutech.controller;

import com.edutech.edutech.model.Instructor;
import com.edutech.edutech.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructores")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public String guardarInstructor(@RequestBody Instructor instructor) {
        return instructorService.guardarInstructor(instructor);
    }

    @GetMapping
    public List<Instructor> listarInstructores() {
        return instructorService.listarInstructores();
    }

    @DeleteMapping("/{id}")
    public String eliminarInstructor(@PathVariable int id) {
        return instructorService.eliminarInstructorPorId(id);
    }
}
