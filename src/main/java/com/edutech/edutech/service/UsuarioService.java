package com.edutech.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.model.Persona;
import com.edutech.edutech.model.Curso;
import com.edutech.edutech.model.Perfil;
import com.edutech.edutech.model.Preferencia;
import com.edutech.edutech.repository.PersonaRepository;
import com.edutech.edutech.repository.UsuarioRepository;
import com.edutech.edutech.repository.CursoRepository;
import com.edutech.edutech.repository.PerfilRepository;
import com.edutech.edutech.repository.PreferenciaRepository;
//Fernando Huamanchumo
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private PreferenciaRepository preferenciaRepository;


    // Crear usuario con validaciones simples
    public String crearUsuario(Usuario usuario) {
        // Regla 1: verificar si el mail ya existe
        if (usuarioRepository.findByMail(usuario.getMail()) != null) {
            return "Ya existe un usuario registrado con ese correo.";
        }

        // Regla 5: verificar si la persona existe por RUT
        Persona persona = personaRepository.findByRut(usuario.getPersona().getRut());
        if (persona == null) {
            return "No se encontró una persona con el RUT proporcionado.";
        }

        // Regla 2: validar que los correos coincidan
        if (!usuario.getMail().equalsIgnoreCase(persona.getMail())) {
            return "El correo del usuario no coincide con el correo de la persona asociada.";
        }

        // Regla 3: validar que la contraseña no esté vacía
        String pass = usuario.getPass();
        if (pass == null || pass.trim().isEmpty()) {
            return "La contraseña no puede estar vacía.";
}
        // Regla 4: validar que el estado sea 'activo' o 'inactivo'
        String estado = usuario.getEstado();
        if (estado == null) {
        return "El estado no puede ser nulo.";
        }
        if (!estado.equals("activo") && !estado.equals("inactivo")) {
        return "El estado del usuario debe ser 'activo' o 'inactivo'.";
        }

        // Asignar persona real encontrada desde la BD
        usuario.setPersona(persona);

        // Guardar el usuario si pasó todas las validaciones
        usuarioRepository.save(usuario);
        return "Usuario registrado correctamente.";
    }

    // Buscar usuario por correo
    public Usuario buscarPorMail(String mail) {
        return usuarioRepository.findByMail(mail);
    }

    // Eliminar usuario por correo
    public String eliminarUsuario(String mail) {
        Usuario usuario = usuarioRepository.findByMail(mail);
        if (usuario == null) {
            return "No se encontró ningún usuario con ese correo.";
        }
        usuarioRepository.delete(usuario);
        return "Usuario eliminado correctamente.";
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public String asignarCurso(int idUsuario, int idCurso) {
        if (!usuarioRepository.existsById(idUsuario)) {
            return "El usuario ingresado no existe.";
        }
        if (!cursoRepository.existsById(idCurso)) {
            return "El curso ingresado no existe.";
        }
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        Curso curso = cursoRepository.findById(idCurso).get();
        if (usuario.getCursos().contains(curso)) {
            return "El curso ya está asignado a este usuario.";
        }
        usuario.getCursos().add(curso);
        usuarioRepository.save(usuario);
        return "Curso asignado al usuario correctamente.";
    }

    public String asignarPerfil(int idUsuario, int idPerfil) {
        if (!usuarioRepository.existsById(idUsuario)) {
            return "El usuario ingresado no existe.";
        }
        if (!perfilRepository.existsById(idPerfil)) {
            return "El perfil ingresado no existe.";
        }
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        Perfil perfil = perfilRepository.findById(idPerfil).get();
        if (usuario.getPerfiles().contains(perfil)) {
            return "El perfil ya está asignado a este usuario.";
        }
        usuario.getPerfiles().add(perfil);
        usuarioRepository.save(usuario);
        return "Perfil asignado al usuario correctamente.";
    }

    public String asignarPreferencia(int idUsuario, int idPreferencia) {
        if (!usuarioRepository.existsById(idUsuario)) {
            return "El usuario ingresado no existe.";
        }
        if (!preferenciaRepository.existsById(idPreferencia)) {
            return "La preferencia ingresada no existe.";
        }
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        Preferencia preferencia = preferenciaRepository.findById(idPreferencia).get();
        if (usuario.getPreferencias().contains(preferencia)) {
            return "La preferencia ya está asignada a este usuario.";
        }
        usuario.getPreferencias().add(preferencia);
        usuarioRepository.save(usuario);
        return "Preferencia asignada al usuario correctamente.";
    }
}
