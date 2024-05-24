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
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Entity
@Table(name = "Citas")
public class Clase_Citas {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_Citas")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Citas;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "fora")
    private LocalTime hora;

    @Column(name = "tipo_Consulta")
    private String tipo_Consulta;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_Auto_Fk")
    private Clase_Auto id_Auto_Fk;

    @ManyToOne
    @JoinColumn(name = "id_Chofer_Fk")
    private Clase_Chofer id_Chofer_Fk;

    public Clase_Citas() {
    }

    public Clase_Citas(Long id_Citas, LocalDate fecha, LocalTime hora, String tipo_Consulta, String descripcion, Clase_Auto id_Auto_Fk, Clase_Chofer id_Chofer_Fk) {
        this.id_Citas = id_Citas;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo_Consulta = tipo_Consulta;
        this.descripcion = descripcion;
        this.id_Auto_Fk = id_Auto_Fk;
        this.id_Chofer_Fk = id_Chofer_Fk;
    }

    public Long getId_Citas() {
        return id_Citas;
    }

    public void setId_Citas(Long id_Citas) {
        this.id_Citas = id_Citas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTipo_Consulta() {
        return tipo_Consulta;
    }

    public void setTipo_Consulta(String tipo_Consulta) {
        this.tipo_Consulta = tipo_Consulta.toUpperCase();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    public Clase_Auto getId_Auto_Fk() {
        return id_Auto_Fk;
    }

    public void setId_Auto_Fk(Clase_Auto id_Auto_Fk) {
        this.id_Auto_Fk = id_Auto_Fk;
    }

    public Clase_Chofer getId_Chofer_Fk() {
        return id_Chofer_Fk;
    }

    public void setId_Chofer_Fk(Clase_Chofer id_Chofer_Fk) {
        this.id_Chofer_Fk = id_Chofer_Fk;
    }

}
