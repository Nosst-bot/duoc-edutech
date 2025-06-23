package com.edutech.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.model.CuponDescuento;
import com.edutech.edutech.repository.CuponDescuentoRepository;
import com.edutech.edutech.service.CuponDescuentoService;

@ExtendWith(MockitoExtension.class)
public class CuponDescuentoServiceTest {
    @Mock
    private CuponDescuentoRepository cuponDescuentoRepository;
    @InjectMocks
    private CuponDescuentoService cuponDescuentoService;

    @Test
    void crearCuponYaExiste() {
        CuponDescuento cupon = new CuponDescuento();
        cupon.setCodigo("ABC");
        when(cuponDescuentoRepository.existsById("ABC")).thenReturn(true);
        String resultado = cuponDescuentoService.crearCupon(cupon);
        assertEquals("Ya existe un cupón con ese código.", resultado);
    }

    @Test
    void crearCuponNuevo() {
        CuponDescuento cupon = new CuponDescuento();
        cupon.setCodigo("DEF");
        when(cuponDescuentoRepository.existsById("DEF")).thenReturn(false);
        String resultado = cuponDescuentoService.crearCupon(cupon);
        assertEquals("Cupón creado correctamente.", resultado);
        verify(cuponDescuentoRepository).save(cupon);
    }

    @Test
    void eliminarCuponNoExiste() {
        when(cuponDescuentoRepository.existsById("NO")).thenReturn(false);
        String resultado = cuponDescuentoService.eliminarCuponPorCodigo("NO");
        assertEquals("No se encontró un cupón con ese código.", resultado);
    }

    @Test
    void eliminarCuponExiste() {
        when(cuponDescuentoRepository.existsById("SI")).thenReturn(true);
        String resultado = cuponDescuentoService.eliminarCuponPorCodigo("SI");
        assertEquals("Cupón eliminado correctamente.", resultado);
        verify(cuponDescuentoRepository).deleteById("SI");
    }
}
