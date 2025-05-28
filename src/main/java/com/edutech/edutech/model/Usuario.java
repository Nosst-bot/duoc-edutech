package com.edutech.edutech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.util.List;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String mail;
    private String pass;
    private String estado;
    @OneToOne
    @JoinColumn(name = "idPersona", unique = true)
    private Persona persona;
    @ManyToMany
    private List<Perfil> perfiles;
    @ManyToMany
    private List<Preferencia> preferencias;
    @ManyToMany
    private List<Curso> cursos;

    public Usuario() {}

    public Usuario(int idUsuario, String mail, String pass, String estado) {
        this.idUsuario = idUsuario;
        this.mail = mail;
        this.pass = pass;
        this.estado = estado;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public List<Perfil> getPerfiles() { return perfiles; }
    public void setPerfiles(List<Perfil> perfiles) { this.perfiles = perfiles; }
    public List<Preferencia> getPreferencias() { return preferencias; }
    public void setPreferencias(List<Preferencia> preferencias) { this.preferencias = preferencias; }
    public List<Curso> getCursos() { return cursos; }
    public void setCursos(List<Curso> cursos) { this.cursos = cursos; }



    
}
