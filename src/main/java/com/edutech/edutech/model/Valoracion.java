package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idValoracion;

    private String usuarioMail;
    private String cursoSigla;
    private int valoracion; // 1 a 5

    public Valoracion() {}

    // Getters y setters
    public int getIdValoracion() { return idValoracion; }
    public void setIdValoracion(int idValoracion) { this.idValoracion = idValoracion; }
    public String getUsuarioMail() { return usuarioMail; }
    public void setUsuarioMail(String usuarioMail) { this.usuarioMail = usuarioMail; }
    public String getCursoSigla() { return cursoSigla; }
    public void setCursoSigla(String cursoSigla) { this.cursoSigla = cursoSigla; }
    public int getValoracion() { return valoracion; }
    public void setValoracion(int valoracion) { this.valoracion = valoracion; }
}
