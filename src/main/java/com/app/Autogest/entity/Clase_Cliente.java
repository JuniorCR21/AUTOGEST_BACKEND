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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
/**
 *
 * @author CLAUDIO CRUZADO
 */

@Entity
@Table(name = "Cliente")
public class Clase_Cliente implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Column(name = "Id_Cliente")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Cliente;
    
    @Column(name = "Ruc", length = 11)
    @NotBlank(message = "El campo Ruc no puede estar en blanco")
    @Pattern(regexp = "\\d{11}", message = "El campo Ruc debe contener 11 dígitos numéricos")
    private String ruc;
    
    @Column(name = "Razon_Social", length = 100)
    @NotBlank(message = "El campo Razon Social no puede estar en blanco")
    private String razon_Social;
    
    @Column(name = "Representante_Legal", length = 100)
    @NotBlank(message = "El campo Representante Legal no puede estar en blanco")
    private String representante_Legal;
    
    @Column(name = "Telefono", length = 20 )
    private String telefono;
    

    public Clase_Cliente() {
    }

    public Clase_Cliente(Long id_Cliente, String ruc, String razon_Social, String representante_Legal, String telefono) {
        this.id_Cliente = id_Cliente;
        this.ruc = ruc;
        this.razon_Social = razon_Social;
        this.representante_Legal = representante_Legal;
        this.telefono = telefono;
    }

    public Long getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(Long id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_Social() {
        return razon_Social.toUpperCase();
    }

    public void setRazon_Social(String razon_Social) {
        this.razon_Social = razon_Social.toUpperCase();
    }

    public String getRepresentante_Legal() {
        return representante_Legal;
    }

    public void setRepresentante_Legal(String representante_Legal) {
        this.representante_Legal = representante_Legal.toUpperCase();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
   
}
