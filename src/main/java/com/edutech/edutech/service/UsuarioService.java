package com.edutech.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.model.Persona;
import com.edutech.edutech.repository.PersonaRepository;
import com.edutech.edutech.repository.UsuarioRepository;
//Fernando Huamanchumo
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;


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
}
