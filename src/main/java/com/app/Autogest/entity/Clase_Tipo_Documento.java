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
@Table(name = "TipoDocumento")
public class Clase_Tipo_Documento {
    
    private static final long serialVersionUID=1L;
    
    @Column(name = "Id_Tipo_Documento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Tipo_Documento;
    
    @Column(name="Tipo", length = 30)
    private String tipo;

    public Clase_Tipo_Documento() {
    }

    public Clase_Tipo_Documento(Long Id_Tipo_Documento, String tipo) {
        this.Id_Tipo_Documento = Id_Tipo_Documento;
        this.tipo = tipo;
    }

    public Long getId_Tipo_Documento() {
        return Id_Tipo_Documento;
    }

    public void setId_Tipo_Documento(Long Id_Tipo_Documento) {
        this.Id_Tipo_Documento = Id_Tipo_Documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.toUpperCase();
    }
    
}
