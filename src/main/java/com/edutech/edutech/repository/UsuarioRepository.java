package com.edutech.edutech.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByMail(String mail);

}
