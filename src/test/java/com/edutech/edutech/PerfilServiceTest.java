package com.edutech.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.edutech.model.Perfil;
import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.repository.PerfilRepository;
import com.edutech.edutech.repository.UsuarioRepository;
import com.edutech.edutech.service.PerfilService;


@ExtendWith(MockitoExtension.class)
public class PerfilServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private PerfilRepository perfilRepository;
    @InjectMocks
    private PerfilService perfilService;

    @Test
    void crearPerfilConTagDuplicado() {
        Perfil perfilExistente = new Perfil();
        perfilExistente.setTag("ADMIN");

        Perfil nuevoPerfil = new Perfil();
        nuevoPerfil.setTag("ADMIN");

        // Simular que ya existe un perfil con ese tag
        when(perfilRepository.findByTag("ADMIN")).thenReturn(perfilExistente);

        String resultado = perfilService.crearPerfil(nuevoPerfil);

        assertEquals("Ya existe un perfil con ese tag.", resultado);
    }


    @Test
    void eliminarPerfilAsignadoAUsuarios() {
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(1);
        perfil.setTag("CLIENTE");

        // Simula que tiene usuarios asignados
        Usuario usuario = new Usuario();
        Set<Usuario> usuarios = new HashSet<>();
        usuarios.add(usuario);
        perfil.setUsuarios(usuarios);

        when(perfilRepository.findById(1)).thenReturn(Optional.of(perfil));

        // Suponiendo que agregas esta validación en el servicio como mejora
        String resultado = perfilService.eliminarPerfilPorId(1);

        assertEquals("No se puede eliminar: el perfil está asignado a uno o más usuarios.", resultado);
    }

    @Test
    void crearPerfilCorrectamente() {
        Perfil nuevoPerfil = new Perfil();
        nuevoPerfil.setTag("INSTRUCTOR");
        nuevoPerfil.setNombre("Instructor");

        when(perfilRepository.findByTag("INSTRUCTOR")).thenReturn(null);

        String resultado = perfilService.crearPerfil(nuevoPerfil);

        assertEquals("Perfil creado correctamente.", resultado);
        verify(perfilRepository).save(nuevoPerfil);
    }

}
