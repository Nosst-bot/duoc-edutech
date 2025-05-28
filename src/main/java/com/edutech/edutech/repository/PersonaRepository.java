package com.edutech.edutech.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.edutech.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByRut(String rut);


}
