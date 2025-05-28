package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @ManyToOne
    @JoinColumn(name = "idPregunta")
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private String descripcion;

    public Respuesta() {}

    // Getters y setters
    public int getIdRespuesta() { return idRespuesta; }
    public void setIdRespuesta(int idRespuesta) { this.idRespuesta = idRespuesta; }
    public Pregunta getPregunta() { return pregunta; }
    public void setPregunta(Pregunta pregunta) { this.pregunta = pregunta; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
