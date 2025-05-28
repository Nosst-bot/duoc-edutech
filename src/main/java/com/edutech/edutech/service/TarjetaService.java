package com.edutech.edutech.service;

import com.edutech.edutech.model.Tarjeta;
import com.edutech.edutech.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;

    public String crearTarjeta(Tarjeta tarjeta) {
        tarjetaRepository.save(tarjeta);
        return "Tarjeta creada correctamente.";
    }

    public List<Tarjeta> listarTarjetas() {
        return tarjetaRepository.findAll();
    }

    public String eliminarTarjetaPorId(int id) {
        if (!tarjetaRepository.existsById(id)) {
            return "No se encontró una tarjeta con ese ID.";
        }
        tarjetaRepository.deleteById(id);
        return "Tarjeta eliminada correctamente.";
    }
}
