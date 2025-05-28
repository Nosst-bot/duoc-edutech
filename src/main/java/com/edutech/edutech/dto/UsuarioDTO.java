package com.edutech.edutech.dto;

public class UsuarioDTO {

    private int idUsuario;
    private String mail;
    private String pass;
    private String nombreCompleto;

    
    public UsuarioDTO(int idUsuario, String mail, String pass, String nombreCompleto) {
        this.idUsuario = idUsuario;
        this.mail = mail;
        this.pass = pass;
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


    public String getPass() {
        return pass;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }


    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    
    
    
}
