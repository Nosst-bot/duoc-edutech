package com.edutech.edutech.service;

import com.edutech.edutech.model.CuponDescuento;
import com.edutech.edutech.repository.CuponDescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuponDescuentoService {
    @Autowired
    private CuponDescuentoRepository cuponDescuentoRepository;

    public String crearCupon(CuponDescuento cupon) {
        if (cuponDescuentoRepository.existsById(cupon.getCodigo())) {
            return "Ya existe un cupón con ese código.";
        }
        cuponDescuentoRepository.save(cupon);
        return "Cupón creado correctamente.";
    }

    public List<CuponDescuento> listarCupones() {
        return cuponDescuentoRepository.findAll();
    }

    public String eliminarCuponPorCodigo(String codigo) {
        if (!cuponDescuentoRepository.existsById(codigo)) {
            return "No se encontró un cupón con ese código.";
        }
        cuponDescuentoRepository.deleteById(codigo);
        return "Cupón eliminado correctamente.";
    }
}
