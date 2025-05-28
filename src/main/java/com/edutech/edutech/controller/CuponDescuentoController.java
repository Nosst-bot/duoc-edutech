package com.edutech.edutech.controller;

import com.edutech.edutech.model.CuponDescuento;
import com.edutech.edutech.service.CuponDescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupones")
public class CuponDescuentoController {
    @Autowired
    private CuponDescuentoService cuponDescuentoService;

    @PostMapping
    public String crearCupon(@RequestBody CuponDescuento cupon) {
        return cuponDescuentoService.crearCupon(cupon);
    }

    @GetMapping
    public List<CuponDescuento> listarCupones() {
        return cuponDescuentoService.listarCupones();
    }

    @DeleteMapping("/{codigo}")
    public String eliminarCupon(@PathVariable String codigo) {
        return cuponDescuentoService.eliminarCuponPorCodigo(codigo);
    }
}
