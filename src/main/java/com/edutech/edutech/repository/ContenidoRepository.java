package com.edutech.edutech.repository;

import com.edutech.edutech.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {
    Contenido findByTitulo(String titulo);
}
