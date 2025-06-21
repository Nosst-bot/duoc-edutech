package com.edutech.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.model.Persona;
import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.repository.PersonaRepository;
import com.edutech.edutech.repository.UsuarioRepository;

import com.edutech.edutech.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {


    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void crearUsuarioConCorreoDuplicado() {
        Usuario usuario = new Usuario();
        usuario.setMail("admin@correo.com");

        // Simula que ya existe un usuario con ese correo
        when(usuarioRepository.findByMail("admin@correo.com")).thenReturn(new Usuario());

        String resultado = usuarioService.crearUsuario(usuario);

        assertEquals("Ya existe un usuario registrado con ese correo.", resultado);
    }
    @Test
    void crearUsuarioConPersonaNoExistente() {
        Usuario usuario = new Usuario();
        Persona personaVinculada = new Persona();
        personaVinculada.setRut("11.111.111-1");
        usuario.setPersona(personaVinculada);
        usuario.setMail("nuevo@correo.com");

        // Simula que no se encuentra la persona en la BD
        when(usuarioRepository.findByMail("nuevo@correo.com")).thenReturn(null);
        when(personaRepository.findByRut("11.111.111-1")).thenReturn(null);

        String resultado = usuarioService.crearUsuario(usuario);

        assertEquals("No se encontró una persona con el RUT proporcionado.", resultado);
    }
    
    @Test
    void crearUsuarioCorrecto() {
        Usuario usuario = new Usuario();
        usuario.setMail("nuevo@correo.com");
        usuario.setPass("123456");
        usuario.setEstado("activo");

        Persona persona = new Persona();
        persona.setRut("22.222.222-2");
        persona.setMail("nuevo@correo.com"); // debe coincidir con el mail del usuario
        usuario.setPersona(persona);

        // Simular que no existe el correo
        when(usuarioRepository.findByMail("nuevo@correo.com")).thenReturn(null);
        // Simular que la persona existe
        when(personaRepository.findByRut("22.222.222-2")).thenReturn(persona);

        String resultado = usuarioService.crearUsuario(usuario);

        assertEquals("Usuario registrado correctamente.", resultado);
        verify(usuarioRepository).save(usuario); // Verifica que se guardó
    }


}
