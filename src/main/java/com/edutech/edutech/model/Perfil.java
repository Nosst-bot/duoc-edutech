package com.edutech.edutech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfil;

    private String tag; // Ej: "ADMIN", "CLIENTE"

    private String nombre;

    @ManyToMany(mappedBy = "perfiles")
    @JsonIgnore // para evitar recursión infinita en JSON
    private Set<Usuario> usuarios;

    public Perfil() {}

    public Perfil(int idPerfil, String tag, String nombre) {
        this.idPerfil = idPerfil;
        this.tag = tag;
        this.nombre = nombre;
       
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(Set<Usuario> usuarios) { this.usuarios = usuarios; }
}
