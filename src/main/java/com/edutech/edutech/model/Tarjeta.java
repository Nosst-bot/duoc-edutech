package com.edutech.edutech.model;

import jakarta.persistence.*;

@Entity
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarjeta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idFormaPago")
    private FormaPago formaPago;

    private String numero;
    private String vencimiento;

    public Tarjeta() {}

    // Getters y setters
    public int getIdTarjeta() { return idTarjeta; }
    public void setIdTarjeta(int idTarjeta) { this.idTarjeta = idTarjeta; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public FormaPago getFormaPago() { return formaPago; }
    public void setFormaPago(FormaPago formaPago) { this.formaPago = formaPago; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getVencimiento() { return vencimiento; }
    public void setVencimiento(String vencimiento) { this.vencimiento = vencimiento; }
}
