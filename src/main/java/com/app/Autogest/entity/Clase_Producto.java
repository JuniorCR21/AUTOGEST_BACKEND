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
@Table(name = "Producto")
public class Clase_Producto {

    private static final long serialVersionUID = 1L;

    @Column(name = "Id_Producto")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Producto;

    @Column(name = "Nombre", length = 40)
    private String nombre;
    
    @Column(name = "Descripcion", length = 40)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "Id_Familia_Fk")
    private Clase_Familia idFamiliaFk;

    public Clase_Producto() {
    }

    public Clase_Producto(Long id_Producto, String nombre, String descripcion, Clase_Familia idFamiliaFk) {
        this.id_Producto = id_Producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idFamiliaFk = idFamiliaFk;
    }

    public Long getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(Long id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    public Clase_Familia getIdFamiliaFk() {
        return idFamiliaFk;
    }

    public void setIdFamiliaFk(Clase_Familia idFamiliaFk) {
        this.idFamiliaFk = idFamiliaFk;
    }

    

}
