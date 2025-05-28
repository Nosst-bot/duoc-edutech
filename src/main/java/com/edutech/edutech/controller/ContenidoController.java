package com.edutech.edutech.controller;

import com.edutech.edutech.model.Contenido;
import com.edutech.edutech.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public List<Contenido> listar() {
        return contenidoService.listarContenidos();
    }

    @PostMapping
    public String crear(@RequestBody Contenido contenido) {
        return contenidoService.crearContenido(contenido);
    }
}
