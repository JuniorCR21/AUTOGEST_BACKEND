/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
@Table(name = "Servicio_Realizado")
public class Clase_Servicio_Realizado {

    private static final long serialVersionUID = 1L;

    @Column(name = "Id_Servicio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_Servicio;

    @Column(name = "Fecha_Entrega")
    @Temporal(TemporalType.DATE)
    private Date Fecha_Entrega;

    @Column(name = "Costo_Servicio_Total")
    private double Costo_Servicio_Total;

    @Column(name = "Costo_Producto_Total")
    private double Costo_Producto_Total;

    @Column(name = "Costo_Total")
    private double Costo_Total;
    
    @OneToOne
    @JoinColumn(name = "Id_Orden_Ingreso_Fk")
    private Clase_Orden_Ingreso Id_Orden_Ingreso_Fk;
    

    @OneToMany(mappedBy = "Id_Servicio_FK", cascade = CascadeType.ALL)
    private Set<Clase_Detalle_Empleado_Servicio> listaEmpleado = new HashSet<>();
    
    @OneToMany(mappedBy = "Id_Servicio_FK", cascade = CascadeType.ALL)
    private Set<Clase_Detalle_Servicio> listaServicio = new HashSet<>();
    

}
