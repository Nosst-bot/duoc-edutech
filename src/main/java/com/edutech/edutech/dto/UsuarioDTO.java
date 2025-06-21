package com.edutech.edutech.dto;

public class UsuarioDTO {

    private int idUsuario;
    private String mail;
    private String estado;
    private String nombreCompleto;

    
    public UsuarioDTO(int idUsuario, String mail, String estado, String nombreCompleto) {
        this.idUsuario = idUsuario;
        this.mail = mail;
        this.estado = estado;
        this.nombreCompleto = nombreCompleto;
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


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }


    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    
    
    
}
