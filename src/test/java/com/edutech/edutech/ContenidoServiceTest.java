package com.edutech.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.model.Contenido;
import com.edutech.edutech.repository.ContenidoRepository;
import com.edutech.edutech.service.ContenidoService;

@ExtendWith(MockitoExtension.class)
public class ContenidoServiceTest {
    @Mock
    private ContenidoRepository contenidoRepository;

    @InjectMocks
    private ContenidoService contenidoService;

    @Test
    void crearContenidoYaExiste() {
        Contenido contenido = new Contenido();
        contenido.setTitulo("Test");
        when(contenidoRepository.findByTitulo("Test")).thenReturn(new Contenido());
        String resultado = contenidoService.crearContenido(contenido);
        assertEquals("Ya existe un contenido con ese titulo.", resultado);
    }

    @Test
    void crearContenidoNuevo() {
        Contenido contenido = new Contenido();
        contenido.setTitulo("Nuevo");
        when(contenidoRepository.findByTitulo("Nuevo")).thenReturn(null);
        String resultado = contenidoService.crearContenido(contenido);
        assertEquals("Contenido creado con exito", resultado);
        verify(contenidoRepository).save(contenido);
    }

    @Test
    void eliminarContenidoNoExiste() {
        when(contenidoRepository.existsById(1)).thenReturn(false);
        String resultado = contenidoService.eliminarContenidoPorId(1);
        assertEquals("No se encontró un contenido con ese ID.", resultado);
    }

    @Test
    void eliminarContenidoExiste() {
        when(contenidoRepository.existsById(2)).thenReturn(true);
        String resultado = contenidoService.eliminarContenidoPorId(2);
        assertEquals("Contenido eliminado correctamente.", resultado);
        verify(contenidoRepository).deleteById(2);
    }
}
