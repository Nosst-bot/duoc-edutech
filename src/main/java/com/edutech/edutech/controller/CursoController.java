package com.edutech.edutech.controller;

import com.edutech.edutech.model.Curso;
import com.edutech.edutech.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.allCursos();
    }

    @GetMapping("/id/{id}")
    public List<Curso> buscarPorId(@PathVariable int id) {
        return cursoService.buscarPorId(id);
    }

    @GetMapping("/sigla/{sigla}")
    public List<Curso> buscarPorSigla(@PathVariable String sigla) {
        return cursoService.buscarPorSigla(sigla);
    }

    @PostMapping
    public String crearCurso(@RequestBody Curso newCurso) {
        return cursoService.crearCurso(newCurso);
    }

    @PostMapping("/asignar-contenido/{idCurso}/{idContenido}")
    public String asignarContenidoACurso(@PathVariable int idCurso, @PathVariable int idContenido) {
        return cursoService.asignarContenido(idCurso, idContenido);
    }

    @DeleteMapping("/{id}")
    public String eliminarCurso(@PathVariable int id) {
        return cursoService.eliminarCursoPorId(id);
    }

}
