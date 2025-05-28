package com.edutech.edutech.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.model.Persona;
import com.edutech.edutech.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public String guardarPersona(@RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }

    @GetMapping
    public List<Persona> listarPersonas(){
        return personaService.listar();
    }

    @GetMapping("/{rut}")
    public String buscarPorRut(@PathVariable String rut){
        return personaService.buscarPorRut(rut);
    }

    @DeleteMapping
    public String eliminarPorRut(@PathVariable String rut){
        return personaService.eliminarPorRut(rut);

    }

}
