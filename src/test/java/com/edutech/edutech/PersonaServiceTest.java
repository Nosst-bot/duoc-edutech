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
import com.edutech.edutech.service.PersonaService;

@ExtendWith(MockitoExtension.class)
public class PersonaServiceTest {
    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;

    @Test
    void almacenarPersonaYaExiste() {
        Persona persona = new Persona();
        persona.setRut("11.111.111-1");
        persona.setNombre("Juan");

        // Simula que ya existe una persona con ese RUT
        when(personaRepository.findByRut("11.111.111-1"))
            .thenReturn(new Persona());

        String resultado = personaService.guardarPersona(persona);

        assertEquals("Persona con Rut: 11.111.111-1, ya se encuentra ingresada", resultado);
    }

    @Test
    void almacenarPersonaNueva() {
        Persona persona = new Persona();
        persona.setRut("22.222.222-2");
        persona.setNombre("María");

        // Simula que la persona NO existe en BD
        when(personaRepository.findByRut("22.222.222-2")).thenReturn(null);

        String resultado = personaService.guardarPersona(persona);

        assertEquals("Persona almacenada correctamente", resultado);
        verify(personaRepository).save(persona); // Verifica que se guardó
    }

    @Test
    void eliminarPersonaConUsuarioAsignado() {
        Persona persona = new Persona();
        persona.setRut("33.333.333-3");
        persona.setNombre("Luis");

        Usuario mockUsuario = new Usuario(); // Simulamos que tiene un usuario
        persona.setUsuario(mockUsuario);

        when(personaRepository.findByRut("33.333.333-3")).thenReturn(persona);

        String resultado = personaService.eliminarPorRut("33.333.333-3");

        assertEquals("No se puede eliminar. Esta persona tiene un usuario asociado.", resultado);
    }


}
