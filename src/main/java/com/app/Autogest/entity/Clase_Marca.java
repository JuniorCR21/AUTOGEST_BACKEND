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
@Table(name = "Marca")
public class Clase_Marca {
    
    private static final long serialVersionUID=1L;
    
    @Column(name = "Id_Marca")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Marca;
    
    @Column(name="Marca", length = 40)
    private String marca;
    
    @Column(name="Estado")
    private int estado;

    public Clase_Marca() {
    }

    public Clase_Marca(Long Id_Marca, String marca, int estado) {
        this.Id_Marca = Id_Marca;
        this.marca = marca;
        this.estado = estado;
    }

    public Long getId_Marca() {
        return Id_Marca;
    }

    public void setId_Marca(Long Id_Marca) {
        this.Id_Marca = Id_Marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca.toUpperCase();
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
