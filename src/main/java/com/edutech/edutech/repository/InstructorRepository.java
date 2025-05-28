package com.edutech.edutech.repository;

import com.edutech.edutech.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    Instructor findByRut(String rut);
}
