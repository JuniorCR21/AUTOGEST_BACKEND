/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Entity
@Table(name = "Modelo")
public class Clase_Modelo {

    private static final long serialVersionUID = 1L;

    @Column(name = "Id_Modelo")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Modelo;

    @Column(name = "Modelo", length = 40)
    private String modelo;
    
    @Column(name = "estado")
    private int estado;

    @ManyToOne
    @JoinColumn(name = "Id_Marca_Fk")
    private Clase_Marca idMarcaFK;

    public Clase_Modelo() {
    }

    public Clase_Modelo(Long Id_Modelo, String modelo, int estado, Clase_Marca idMarcaFK) {
        this.Id_Modelo = Id_Modelo;
        this.modelo = modelo;
        this.estado = estado;
        this.idMarcaFK = idMarcaFK;
    }

    public Long getId_Modelo() {
        return Id_Modelo;
    }

    public void setId_Modelo(Long Id_Modelo) {
        this.Id_Modelo = Id_Modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo.toUpperCase();
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Clase_Marca getIdMarcaFK() {
        return idMarcaFK;
    }

    public void setIdMarcaFK(Clase_Marca idMarcaFK) {
        this.idMarcaFK = idMarcaFK;
    }

}
