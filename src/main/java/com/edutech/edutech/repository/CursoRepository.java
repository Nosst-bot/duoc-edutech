package com.edutech.edutech.repository;

import com.edutech.edutech.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Curso findBySigla(String sigla);

}
