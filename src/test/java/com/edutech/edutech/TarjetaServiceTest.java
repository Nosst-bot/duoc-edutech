package com.edutech.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.model.Tarjeta;
import com.edutech.edutech.repository.TarjetaRepository;
import com.edutech.edutech.service.TarjetaService;

@ExtendWith(MockitoExtension.class)
public class TarjetaServiceTest {
    @Mock
    private TarjetaRepository tarjetaRepository;
    @InjectMocks
    private TarjetaService tarjetaService;

    @Test
    void crearTarjetaCorrecta() {
        Tarjeta tarjeta = new Tarjeta();
        String resultado = tarjetaService.crearTarjeta(tarjeta);
        assertEquals("Tarjeta creada correctamente.", resultado);
        verify(tarjetaRepository).save(tarjeta);
    }

    @Test
    void listarTarjetas() {
        tarjetaService.listarTarjetas();
        verify(tarjetaRepository).findAll();
    }

    @Test
    void eliminarTarjetaNoExiste() {
        when(tarjetaRepository.existsById(1)).thenReturn(false);
        String resultado = tarjetaService.eliminarTarjetaPorId(1);
        assertEquals("No se encontró una tarjeta con ese ID.", resultado);
    }

    @Test
    void eliminarTarjetaExiste() {
        when(tarjetaRepository.existsById(2)).thenReturn(true);
        String resultado = tarjetaService.eliminarTarjetaPorId(2);
        assertEquals("Tarjeta eliminada correctamente.", resultado);
        verify(tarjetaRepository).deleteById(2);
    }
}
