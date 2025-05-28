package com.edutech.edutech.controller;

import com.edutech.edutech.model.Tarjeta;
import com.edutech.edutech.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {
    @Autowired
    private TarjetaService tarjetaService;

    @PostMapping
    public String crearTarjeta(@RequestBody Tarjeta tarjeta) {
        return tarjetaService.crearTarjeta(tarjeta);
    }

    @GetMapping
    public List<Tarjeta> listarTarjetas() {
        return tarjetaService.listarTarjetas();
    }

    @DeleteMapping("/{id}")
    public String eliminarTarjeta(@PathVariable int id) {
        return tarjetaService.eliminarTarjetaPorId(id);
    }
}
