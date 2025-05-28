package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class ResultadoEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResultadoEvaluacion;

    @ManyToOne
    @JoinColumn(name = "idUsuarioCurso")
    private UsuarioCurso usuarioCurso;

    @ManyToOne
    @JoinColumn(name = "idEvaluacion")
    private Evaluacion evaluacion;

    private double calificacion;

    public ResultadoEvaluacion() {}

    // Getters y setters
    public int getIdResultadoEvaluacion() { return idResultadoEvaluacion; }
    public void setIdResultadoEvaluacion(int idResultadoEvaluacion) { this.idResultadoEvaluacion = idResultadoEvaluacion; }
    public UsuarioCurso getUsuarioCurso() { return usuarioCurso; }
    public void setUsuarioCurso(UsuarioCurso usuarioCurso) { this.usuarioCurso = usuarioCurso; }
    public Evaluacion getEvaluacion() { return evaluacion; }
    public void setEvaluacion(Evaluacion evaluacion) { this.evaluacion = evaluacion; }
    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }
}
