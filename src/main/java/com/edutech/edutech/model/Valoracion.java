package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idValoracion;

    @OneToOne
    @JoinColumn(name = "idUsuarioCurso")
    private UsuarioCurso usuarioCurso;

    private int valoracion; // 1 a 5

    public Valoracion() {
    }

    // Getters y setters
    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public UsuarioCurso getUsuarioCurso() {
        return usuarioCurso;
    }

    public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
        this.usuarioCurso = usuarioCurso;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
