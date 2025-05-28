package com.edutech.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.model.Preferencia;
import com.edutech.edutech.repository.PreferenciaRepository;
//edgar morales
@Service
public class PreferenciaService {
@Autowired
    private PreferenciaRepository preferenciaRepository;

    // Crear una nueva preferencia
    public String crearPreferencia(Preferencia preferencia) {
        String descripcion = preferencia.getDescripcion();

        // Validación 1: descripción vacía
        if (descripcion == null || descripcion.trim().isEmpty()) {
            return "La descripción no puede estar vacía.";
        }

        // Validación 2: descripción duplicada
        List<Preferencia> existentes = preferenciaRepository.findAll();
        for (Preferencia p : existentes) {
            if (p.getDescripcion().equalsIgnoreCase(descripcion.trim())) {
                return "Ya existe una preferencia con esta descripción.";
            }
        }

        // Guardar preferencia
        preferencia.setDescripcion(descripcion.trim());
        preferenciaRepository.save(preferencia);
        return "Preferencia creada correctamente.";
    }

    // Listar todas las preferencias
    public List<Preferencia> listarPreferencias() {
        return preferenciaRepository.findAll();
    }

    // Eliminar preferencia por ID
    public String eliminarPreferenciaPorId(int id) {
        if (!preferenciaRepository.existsById(id)) {
            return "No se encontró una preferencia con ese ID.";
        }
        preferenciaRepository.deleteById(id);
        return "Preferencia eliminada correctamente.";
    }
}
