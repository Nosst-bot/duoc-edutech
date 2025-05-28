package com.edutech.edutech.model;

import jakarta.persistence.*;
import java.util.List;
import jakarta.persistence.ManyToMany;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInstructor;
    private String rut;
    private String mail;
    private String pass;
    private String nombre;
    private String apellido;
    private String estado;

    @ManyToMany(mappedBy = "instructores")
    private List<Curso> cursos;

    public Instructor() {}

    // Getters y setters
    public int getIdInstructor() { return idInstructor; }
    public void setIdInstructor(int idInstructor) { this.idInstructor = idInstructor; }
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public List<Curso> getCursos() { return cursos; }
    public void setCursos(List<Curso> cursos) { this.cursos = cursos; }
}
