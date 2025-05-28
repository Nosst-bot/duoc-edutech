package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResena;

    @ManyToOne
    @JoinColumn(name = "idUsuarioCurso")
    private UsuarioCurso usuarioCurso;

    private String descripcion;
    private String fecha;

    public Resena() {}

    // Getters y setters
    public int getIdResena() { return idResena; }
    public void setIdResena(int idResena) { this.idResena = idResena; }
    public UsuarioCurso getUsuarioCurso() { return usuarioCurso; }
    public void setUsuarioCurso(UsuarioCurso usuarioCurso) { this.usuarioCurso = usuarioCurso; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
