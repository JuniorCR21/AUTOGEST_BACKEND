/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author CLAUDIO CRUZADO
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DetalleServicio")
public class Clase_Detalle_Servicio {

    private static final long serialVersionUID = 1L;

    @Column(name = "Id_Detalle_Servicio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Detalle_Servicio;
    
    @ManyToOne
    @JoinColumn(name = "Id_Producto_Fk")
    private Clase_Producto Id_Producto_Fk;
    
    @Column(name = "Detalle_Servicio")
    private String Detalle_Servicio;
    
    @Column(name = "Precio_Servicio")
    private double Precio_Servicio;

    @Column(name = "Precio_Producto")
    private double Precio_Producto;
    
    @Column(name = "Precio_Cantidad")
    private double Precio_Cantidad;
    
    @Column(name = "Subtotal_Producto")
    private double Subtotal_Producto;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Servicio_FK")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Clase_Servicio_Realizado Id_Servicio_FK;


}
