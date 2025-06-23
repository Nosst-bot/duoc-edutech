package com.edutech.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.model.Curso;
import com.edutech.edutech.model.Contenido;
import com.edutech.edutech.repository.CursoRepository;
import com.edutech.edutech.repository.ContenidoRepository;
import com.edutech.edutech.repository.InstructorRepository;
import com.edutech.edutech.repository.UsuarioRepository;
import com.edutech.edutech.service.CursoService;

import java.util.Optional;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {
    @Mock private CursoRepository cursoRepository;
    @Mock private ContenidoRepository contenidoRepository;
    @Mock private InstructorRepository instructorRepository;
    @Mock private UsuarioRepository usuarioRepository;
    @InjectMocks private CursoService cursoService;

    @Test
    void crearCursoYaExiste() {
        Curso curso = new Curso();
        curso.setSigla("ABC123");
        when(cursoRepository.findBySigla("ABC123")).thenReturn(new Curso());
        String resultado = cursoService.crearCurso(curso);
        assertEquals("El curso con esa sigla ya existe.", resultado);
    }

    @Test
    void crearCursoNuevo() {
        Curso curso = new Curso();
        curso.setSigla("DEF456");
        when(cursoRepository.findBySigla("DEF456")).thenReturn(null);
        String resultado = cursoService.crearCurso(curso);
        assertEquals("Curso creado correctamente.", resultado);
        verify(cursoRepository).save(curso);
    }

    @Test
    void asignarContenidoNoExiste() {
        when(contenidoRepository.existsById(1)).thenReturn(false);
        String resultado = cursoService.asignarContenido(2, 1);
        assertEquals("El contenido ingresado no existe.", resultado);
    }

    @Test
    void asignarContenidoYaAsignado() {
        Curso curso = new Curso();
        Contenido contenido = new Contenido();
        ArrayList<Contenido> lista = new ArrayList<>();
        lista.add(contenido);
        curso.setContenidos(lista);
        when(contenidoRepository.existsById(1)).thenReturn(true);
        when(cursoRepository.existsById(2)).thenReturn(true);
        when(cursoRepository.findById(2)).thenReturn(Optional.of(curso));
        when(contenidoRepository.findById(1)).thenReturn(Optional.of(contenido));
        String resultado = cursoService.asignarContenido(2, 1);
        assertEquals("El contenido ya está asignado a este curso.", resultado);
    }

    @Test
    void eliminarCursoNoExiste() {
        when(cursoRepository.existsById(1)).thenReturn(false);
        String resultado = cursoService.eliminarCursoPorId(1);
        assertEquals("No se encontró un curso con ese ID.", resultado);
    }

    @Test
    void eliminarCursoExiste() {
        when(cursoRepository.existsById(2)).thenReturn(true);
        String resultado = cursoService.eliminarCursoPorId(2);
        assertEquals("Curso eliminado correctamente.", resultado);
        verify(cursoRepository).deleteById(2);
    }
}
