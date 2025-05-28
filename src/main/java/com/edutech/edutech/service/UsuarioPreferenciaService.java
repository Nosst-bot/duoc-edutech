package com.edutech.edutech.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.model.Preferencia;
import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.model.UsuarioPreferencia;
import com.edutech.edutech.repository.PreferenciaRepository;
import com.edutech.edutech.repository.UsuarioPreferenciaRepository;
import com.edutech.edutech.repository.UsuarioRepository;

@Service
public class UsuarioPreferenciaService {
     @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PreferenciaRepository preferenciaRepository;

    @Autowired
    private UsuarioPreferenciaRepository usuarioPreferenciaRepository;

    public String asignarPreferencia(String mail, int idPreferencia) {
        // Validación 1: Usuario debe existir
        Usuario usuario = usuarioRepository.findByMail(mail);
        if (usuario == null) {
            return "No se encontró el usuario con ese correo.";
        }

        // Validación 2: Preferencia debe existir
        Preferencia preferencia = preferenciaRepository.findById(idPreferencia).orElse(null);
        if (preferencia == null) {
            return "No se encontró la preferencia con ese ID.";
        }

        // Validación 3: No duplicar la asignación
        List<UsuarioPreferencia> relaciones = usuarioPreferenciaRepository.findAll();
        for (UsuarioPreferencia rel : relaciones) {
            if (rel.getUsuario().getMail().equals(mail) &&
                rel.getPreferencia().getId() == idPreferencia) {
                return "El usuario ya tiene esta preferencia asignada.";
            }
        }

        // Asignar preferencia
        usuarioPreferenciaRepository.save(new UsuarioPreferencia(usuario, preferencia));
        return "Preferencia asignada correctamente al usuario.";
    }
}
