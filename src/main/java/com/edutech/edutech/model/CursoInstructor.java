package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class CursoInstructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCursoInstructor;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idInstructor")
    private Instructor instructor;

    public CursoInstructor() {
    }

    // Getters y setters
    public int getIdCursoInstructor() {
        return idCursoInstructor;
    }

    public void setIdCursoInstructor(int idCursoInstructor) {
        this.idCursoInstructor = idCursoInstructor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
