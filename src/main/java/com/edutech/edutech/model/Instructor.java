package com.edutech.edutech.model;

import jakarta.persistence.*;

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
}
