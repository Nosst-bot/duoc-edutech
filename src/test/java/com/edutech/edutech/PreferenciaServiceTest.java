package com.edutech.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.model.Preferencia;
import com.edutech.edutech.repository.PreferenciaRepository;
import com.edutech.edutech.service.PreferenciaService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PreferenciaServiceTest {
    @Mock
    private PreferenciaRepository preferenciaRepository;
    @InjectMocks
    private PreferenciaService preferenciaService;

    @Test
    void crearPreferenciaDescripcionVacia() {
        Preferencia preferencia = new Preferencia();
        preferencia.setDescripcion("");
        String resultado = preferenciaService.crearPreferencia(preferencia);
        assertEquals("La descripción no puede estar vacía.", resultado);
    }

    @Test
    void crearPreferenciaDescripcionDuplicada() {
        Preferencia preferencia = new Preferencia();
        preferencia.setDescripcion("Test");
        List<Preferencia> existentes = new ArrayList<>();
        Preferencia p = new Preferencia();
        p.setDescripcion("Test");
        existentes.add(p);
        when(preferenciaRepository.findAll()).thenReturn(existentes);
        String resultado = preferenciaService.crearPreferencia(preferencia);
        assertEquals("Ya existe una preferencia con esta descripción.", resultado);
    }

    @Test
    void crearPreferenciaCorrecta() {
        Preferencia preferencia = new Preferencia();
        preferencia.setDescripcion("Nueva");
        when(preferenciaRepository.findAll()).thenReturn(new ArrayList<>());
        String resultado = preferenciaService.crearPreferencia(preferencia);
        assertEquals("Preferencia creada correctamente.", resultado);
        verify(preferenciaRepository).save(preferencia);
    }

    @Test
    void eliminarPreferenciaNoExiste() {
        when(preferenciaRepository.existsById(1)).thenReturn(false);
        String resultado = preferenciaService.eliminarPreferenciaPorId(1);
        assertEquals("No se encontró una preferencia con ese ID.", resultado);
    }

    @Test
    void eliminarPreferenciaExiste() {
        when(preferenciaRepository.existsById(2)).thenReturn(true);
        String resultado = preferenciaService.eliminarPreferenciaPorId(2);
        assertEquals("Preferencia eliminada correctamente.", resultado);
        verify(preferenciaRepository).deleteById(2);
    }
}
