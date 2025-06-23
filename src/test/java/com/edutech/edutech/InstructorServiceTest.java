package com.edutech.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.model.Instructor;
import com.edutech.edutech.repository.InstructorRepository;
import com.edutech.edutech.repository.CursoRepository;
import com.edutech.edutech.service.InstructorService;

@ExtendWith(MockitoExtension.class)
public class InstructorServiceTest {
    @Mock private InstructorRepository instructorRepository;
    @Mock private CursoRepository cursoRepository;
    @InjectMocks private InstructorService instructorService;

    @Test
    void guardarInstructorYaExiste() {
        Instructor instructor = new Instructor();
        instructor.setRut("1-9");
        when(instructorRepository.findByRut("1-9")).thenReturn(new Instructor());
        String resultado = instructorService.guardarInstructor(instructor);
        assertEquals("Ya existe un instructor con ese RUT.", resultado);
    }

    @Test
    void guardarInstructorNuevo() {
        Instructor instructor = new Instructor();
        instructor.setRut("2-7");
        when(instructorRepository.findByRut("2-7")).thenReturn(null);
        String resultado = instructorService.guardarInstructor(instructor);
        assertEquals("Instructor almacenado correctamente.", resultado);
        verify(instructorRepository).save(instructor);
    }

    @Test
    void eliminarInstructorNoExiste() {
        when(instructorRepository.existsById(1)).thenReturn(false);
        String resultado = instructorService.eliminarInstructorPorId(1);
        assertEquals("No se encontró un instructor con ese ID.", resultado);
    }

    @Test
    void eliminarInstructorExiste() {
        when(instructorRepository.existsById(2)).thenReturn(true);
        String resultado = instructorService.eliminarInstructorPorId(2);
        assertEquals("Instructor eliminado correctamente.", resultado);
        verify(instructorRepository).deleteById(2);
    }

    @Test
    void asignarCursoNoExiste() {
        when(instructorRepository.existsById(1)).thenReturn(false);
        String resultado = instructorService.asignarCurso(1, 2);
        assertEquals("El instructor ingresado no existe.", resultado);
    }
}
