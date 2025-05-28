package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class UsuarioCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioCurso;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    public UsuarioCurso() {}

    // Getters y setters
    public int getIdUsuarioCurso() { return idUsuarioCurso; }
    public void setIdUsuarioCurso(int idUsuarioCurso) { this.idUsuarioCurso = idUsuarioCurso; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}
