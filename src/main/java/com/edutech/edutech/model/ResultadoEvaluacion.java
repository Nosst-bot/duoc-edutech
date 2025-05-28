package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class ResultadoEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResultadoEvaluacion;

    private String usuarioMail;
    private String cursoSigla;

    @ManyToOne
    @JoinColumn(name = "idEvaluacion")
    private Evaluacion evaluacion;

    private double calificacion;

    public ResultadoEvaluacion() {}

    // Getters y setters
    public int getIdResultadoEvaluacion() { return idResultadoEvaluacion; }
    public void setIdResultadoEvaluacion(int idResultadoEvaluacion) { this.idResultadoEvaluacion = idResultadoEvaluacion; }
    public String getUsuarioMail() { return usuarioMail; }
    public void setUsuarioMail(String usuarioMail) { this.usuarioMail = usuarioMail; }
    public String getCursoSigla() { return cursoSigla; }
    public void setCursoSigla(String cursoSigla) { this.cursoSigla = cursoSigla; }
    public Evaluacion getEvaluacion() { return evaluacion; }
    public void setEvaluacion(Evaluacion evaluacion) { this.evaluacion = evaluacion; }
    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }
}
