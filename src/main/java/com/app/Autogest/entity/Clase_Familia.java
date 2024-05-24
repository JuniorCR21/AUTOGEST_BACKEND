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
import jakarta.persistence.Table;

/**
 *
 * @author CLAUDIO CRUZADO
 */

@Entity
@Table(name = "Familia")
public class Clase_Familia {
    
    private static final long serialVersionUID=1L;
    
    @Column(name = "Id_Familia")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Familia;
    
    @Column(name="Familia", length = 30)
    private String familia;
    
    @Column(name="Estado", length = 30)
    private int estado;

    public Clase_Familia() {
    }

    public Clase_Familia(Long Id_Familia, String familia, int estado) {
        this.Id_Familia = Id_Familia;
        this.familia = familia;
        this.estado = estado;
    }

    public Long getId_Familia() {
        return Id_Familia;
    }

    public void setId_Familia(Long Id_Familia) {
        this.Id_Familia = Id_Familia;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia.toUpperCase();
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
