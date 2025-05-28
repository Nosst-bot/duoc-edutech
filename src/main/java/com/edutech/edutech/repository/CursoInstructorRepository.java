package com.edutech.edutech.repository;

import com.edutech.edutech.model.CursoInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoInstructorRepository extends JpaRepository<CursoInstructor, Integer> {
}
