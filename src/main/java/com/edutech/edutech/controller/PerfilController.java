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

import com.edutech.edutech.model.Perfil;
import com.edutech.edutech.service.PerfilService;
@RestController
@RequestMapping("/perfiles")

public class PerfilController {
    @Autowired
    private PerfilService perfilService;

    @PostMapping
    public String crear(@RequestBody Perfil perfil) {
        return perfilService.crearPerfil(perfil);
    }

    @GetMapping
    public List<Perfil> listar() {
        return perfilService.listarPerfiles();
    }

    @DeleteMapping("/{id}")
    public String eliminarPerfil(@PathVariable int id) {
        return perfilService.eliminarPerfilPorId(id);
    }
}
