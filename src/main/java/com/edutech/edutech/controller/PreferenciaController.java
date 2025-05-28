package com.edutech.edutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.model.Preferencia;
import com.edutech.edutech.service.PreferenciaService;

@RestController
@RequestMapping("/preferencias")
public class PreferenciaController {
     @Autowired
    private PreferenciaService preferenciaService;

    // Crear preferencia
    @PostMapping
    public String crear(@RequestBody Preferencia preferencia) {
        return preferenciaService.crearPreferencia(preferencia);
    }

    // Listar preferencias
    @GetMapping
    public List<Preferencia> listar() {
        return preferenciaService.listarPreferencias();
    }
}
