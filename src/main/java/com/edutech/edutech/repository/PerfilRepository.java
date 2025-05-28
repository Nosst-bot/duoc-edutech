package com.edutech.edutech.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    // Buscar perfil por su tag (ej: "ADMIN", "CLIENTE")
    Perfil findByTag(String tag);

}
