package com.edutech.edutech.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.model.Perfil;
import com.edutech.edutech.model.PerfilUsuario;
import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.repository.PerfilRepository;
import com.edutech.edutech.repository.PerfilUsuarioRepository;
import com.edutech.edutech.repository.UsuarioRepository;


@Service
public class PerfilUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    public String asignarPerfil(String mail, String tag) {
        Usuario usuario = usuarioRepository.findByMail(mail);
        if (usuario == null) {
            return "No se encontró el usuario con ese correo.";
        }

        Perfil perfil = perfilRepository.findByTag(tag);
        if (perfil == null) {
            return "No se encontró el perfil con ese tag.";
        }

        // Regla 3: Verificar si la relación ya existe
        List<PerfilUsuario> relaciones = perfilUsuarioRepository.findAll();
        for (PerfilUsuario rel : relaciones) {
            if (rel.getUsuario().getMail().equals(mail) &&
                rel.getPerfil().getTag().equals(tag)) {
                return "El usuario ya tiene asignado este perfil.";
            }
        }
        // Regla 4: Guardar relación
        perfilUsuarioRepository.save(new PerfilUsuario(usuario, perfil));
        return "Perfil asignado correctamente al usuario.";
    }


}
