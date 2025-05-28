package com.edutech.edutech.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.edutech.dto.UsuarioDTO;
import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    // POST: Crear usuario
    @PostMapping
    public String crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return usuarios.stream()
            .map(usuario -> new UsuarioDTO(
                    usuario.getIdUsuario(),
                    usuario.getMail(),
                    usuario.getEstado(),
                    usuario.getPersona().getNombre()+" " + usuario.getPersona().getApellido()

            ))
            .collect(Collectors.toList());
    }
     // GET: Buscar usuario por mail
    @GetMapping("/{mail}")
    public String buscarUsuarioPorMail(@PathVariable String mail) {
        Usuario usuario = usuarioService.buscarPorMail(mail);
        if (usuario == null) {
            return "Usuario no encontrado con ese correo.";
        }
        return "Usuario encontrado: " + usuario.getMail() + " (Estado: " + usuario.getEstado() + ")";
    }

    // DELETE: Eliminar usuario por mail
    @DeleteMapping("/{mail}")
    public String eliminarUsuario(@PathVariable String mail) {
        return usuarioService.eliminarUsuario(mail);
    }

    @PostMapping("/asignar-curso/{idUsuario}/{idCurso}")
    public String asignarCursoAUsuario(@PathVariable int idUsuario, @PathVariable int idCurso) {
        return usuarioService.asignarCurso(idUsuario, idCurso);
    }

    @PostMapping("/asignar-perfil/{idUsuario}/{idPerfil}")
    public String asignarPerfilAUsuario(@PathVariable int idUsuario, @PathVariable int idPerfil) {
        return usuarioService.asignarPerfil(idUsuario, idPerfil);
    }

    @PostMapping("/asignar-preferencia/{idUsuario}/{idPreferencia}")
    public String asignarPreferenciaAUsuario(@PathVariable int idUsuario, @PathVariable int idPreferencia) {
        return usuarioService.asignarPreferencia(idUsuario, idPreferencia);
    }

}
