package com.edutech.edutech.service;

import com.edutech.edutech.model.Contenido;
import com.edutech.edutech.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Kevin PEÑA
@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Contenido> listarContenidos() {
        return contenidoRepository.findAll();
    }

    public String crearContenido(Contenido newContenido) {
        if (contenidoRepository.findByTitulo(newContenido.getTitulo()) != null) {
            return "Ya existe un contenido con ese titulo.";
        }
        contenidoRepository.save(newContenido);
        return "Contenido creado con exito";
    }

    public String eliminarContenidoPorId(int id) {
        if (!contenidoRepository.existsById(id)) {
            return "No se encontró un contenido con ese ID.";
        }
        contenidoRepository.deleteById(id);
        return "Contenido eliminado correctamente.";
    }
}
