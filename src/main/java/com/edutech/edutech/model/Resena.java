package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResena;

    private String usuarioMail;
    private String cursoSigla;
    private String descripcion;
    private String fecha;

    public Resena() {}

    // Getters y setters
    public int getIdResena() { return idResena; }
    public void setIdResena(int idResena) { this.idResena = idResena; }
    public String getUsuarioMail() { return usuarioMail; }
    public void setUsuarioMail(String usuarioMail) { this.usuarioMail = usuarioMail; }
    public String getCursoSigla() { return cursoSigla; }
    public void setCursoSigla(String cursoSigla) { this.cursoSigla = cursoSigla; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
