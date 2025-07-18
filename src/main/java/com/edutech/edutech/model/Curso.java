package com.edutech.edutech.model;

import jakarta.persistence.*;

import java.util.List;

//Probando que llega al repositorio remoto
// Se deberia tener como entidad principal al curso? o al usuario?
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private String sigla;
    private String nombre;
    private String descripcion;
    private String estado; //activo - desactivado

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<Contenido> contenidos;

    @ManyToMany
    private List<Instructor> instructores;
    @ManyToMany(mappedBy = "cursos")
    private List<Usuario> usuarios;

    public Curso() {
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    public List<Instructor> getInstructores() {
        return instructores;
    }

    public void setInstructores(List<Instructor> instructores) {
        this.instructores = instructores;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
