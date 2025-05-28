package com.edutech.edutech.service;

import com.edutech.edutech.model.Curso;
import com.edutech.edutech.model.Contenido;
import com.edutech.edutech.model.Instructor;
import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.repository.CursoRepository;
import com.edutech.edutech.repository.ContenidoRepository;
import com.edutech.edutech.repository.InstructorRepository;
import com.edutech.edutech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//Kevin Peña

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Curso> allCursos() {
        return cursoRepository.findAll();
    }

    public List<Curso> buscarPorId(int id) {
        List<Curso> list = new ArrayList<>();
        if (cursoRepository.findById(id).isPresent()) {
            list.add(cursoRepository.findById(id).get());
        }

        return list;
    }

    public List<Curso> buscarPorSigla(String sigla) {
        List<Curso> list = new ArrayList<>();
        if (cursoRepository.findBySigla(sigla) != null) {
            list.add(cursoRepository.findBySigla(sigla));
        }

        return list;
    }

    public String crearCurso(Curso newCurso) {
        if (cursoRepository.findBySigla(newCurso.getSigla()) != null) {
            return "El curso con esa sigla ya existe.";
        }

        cursoRepository.save(newCurso);
        return "Curso creado correctamente.";
    }

    public String asignarContenido(int idCurso, int idContenido) {
        if (!contenidoRepository.existsById(idContenido)) {
            return "El contenido ingresado no existe.";
        }
        if (!cursoRepository.existsById(idCurso)) {
            return "El curso ingresado no existe.";
        }

        Curso curso = cursoRepository.findById(idCurso).get();
        Contenido contenido = contenidoRepository.findById(idContenido).get();

        if (curso.getContenidos().contains(contenido)) {
            return "El contenido ya está asignado a este curso.";
        }
        contenido.setCurso(curso);
        curso.getContenidos().add(contenido);
        contenidoRepository.save(contenido);
        return "Contenido asignado al curso correctamente.";
    }

    public String asignarInstructor(int idCurso, int idInstructor) {
        if (!instructorRepository.existsById(idInstructor)) {
            return "El instructor ingresado no existe.";
        }
        if (!cursoRepository.existsById(idCurso)) {
            return "El curso ingresado no existe.";
        }
        Curso curso = cursoRepository.findById(idCurso).get();
        Instructor instructor = instructorRepository.findById(idInstructor).get();
        if (curso.getInstructores().contains(instructor)) {
            return "El instructor ya está asignado a este curso.";
        }
        curso.getInstructores().add(instructor);
        cursoRepository.save(curso);
        return "Instructor asignado al curso correctamente.";
    }

    public String asignarUsuario(int idCurso, int idUsuario) {
        if (!usuarioRepository.existsById(idUsuario)) {
            return "El usuario ingresado no existe.";
        }
        if (!cursoRepository.existsById(idCurso)) {
            return "El curso ingresado no existe.";
        }
        Curso curso = cursoRepository.findById(idCurso).get();
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        if (curso.getUsuarios().contains(usuario)) {
            return "El usuario ya está asignado a este curso.";
        }
        curso.getUsuarios().add(usuario);
        cursoRepository.save(curso);
        return "Usuario asignado al curso correctamente.";
    }

    public String eliminarCursoPorId(int id) {
        if (!cursoRepository.existsById(id)) {
            return "No se encontró un curso con ese ID.";
        }
        cursoRepository.deleteById(id);
        return "Curso eliminado correctamente.";
    }
}
