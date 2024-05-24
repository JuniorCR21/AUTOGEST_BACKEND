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
import java.util.Date;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Entity
@Table(name = "Orden_Ingreso")
public class Clase_Orden_Ingreso {
    
    private static final long serialVersionUID=1L;
    
    @Column(name = "Id_Orden_Ingreso")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_Orden_Ingreso; // Modificar Id_Orden_Ingreso
    
    @Column(name="Numero_Orden")
    private int Numero_Orden;
    
    @Column(name="Fecha_Entrada")
    private Date Fecha_Entrada;
    
    @Column(name="Descripcion_problema", length = 200)
    private String Descripcion_Problema;
    
    @ManyToOne
    @JoinColumn(name = "Id_Cita_Fk")
    private Clase_Citas Id_Cita_Fk;
    
    @ManyToOne
    @JoinColumn(name = "Id_Empleado_Fk")
    private Clase_Empleado Id_Empleado_Fk;

    public Clase_Orden_Ingreso() {
    }

    public Clase_Orden_Ingreso(long Id_Orden_Ingreso, int Numero_Orden, Date Fecha_Entrada, String Descripcion_Problema, Clase_Citas Id_Cita_Fk, Clase_Empleado Id_Empleado_Fk) {
        this.Id_Orden_Ingreso = Id_Orden_Ingreso;
        this.Numero_Orden = Numero_Orden;
        this.Fecha_Entrada = Fecha_Entrada;
        this.Descripcion_Problema = Descripcion_Problema;
        this.Id_Cita_Fk = Id_Cita_Fk;
        this.Id_Empleado_Fk = Id_Empleado_Fk;
    }


    public long getId_Orden_Ingreso() {
        return Id_Orden_Ingreso;
    }

    public void setId_Orden_Ingreso(long Id_Orden_Ingreso) {
        this.Id_Orden_Ingreso = Id_Orden_Ingreso;
    }

    public int getNumero_Orden() {
        return Numero_Orden;
    }

    public void setNumero_Orden(int Numero_Orden) {
        this.Numero_Orden = Numero_Orden;
    }

    public Date getFecha_Entrada() {
        return Fecha_Entrada;
    }

    public void setFecha_Entrada(Date Fecha_Entrada) {
        this.Fecha_Entrada = Fecha_Entrada;
    }

    public String getDescripcion_Problema() {
        return Descripcion_Problema;
    }

    public void setDescripcion_Problema(String Descripcion_Problema) {
        this.Descripcion_Problema = Descripcion_Problema.toUpperCase();
    }

    public Clase_Citas getId_Cita_Fk() {
        return Id_Cita_Fk;
    }

    public void setId_Cita_Fk(Clase_Citas Id_Cita_Fk) {
        this.Id_Cita_Fk = Id_Cita_Fk;
    }

    public Clase_Empleado getId_Empleado_Fk() {
        return Id_Empleado_Fk;
    }

    public void setId_Empleado_Fk(Clase_Empleado Id_Empleado_Fk) {
        this.Id_Empleado_Fk = Id_Empleado_Fk;
    }
    
}
