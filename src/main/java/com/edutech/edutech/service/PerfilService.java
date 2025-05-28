package com.edutech.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.model.Perfil;
import com.edutech.edutech.repository.PerfilRepository;
//edgar morales
@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    public String crearPerfil(Perfil perfil) {
        String tag = perfil.getTag();

        // Validación 1: tag vacío
        if (tag == null || tag.trim().isEmpty()) {
            return "El tag del perfil no puede estar vacío.";
        }

        // Validación 2: tag duplicado
        if (perfilRepository.findByTag(tag.trim()) != null) {
            return "Ya existe un perfil con ese tag.";
        }

        // Guardar el perfil
        perfil.setTag(tag.trim()); // Limpia espacios si vienen del JSON
        perfilRepository.save(perfil);
        return "Perfil creado correctamente.";
    }


    public List<Perfil> listarPerfiles() {
        return perfilRepository.findAll();
    }
}
