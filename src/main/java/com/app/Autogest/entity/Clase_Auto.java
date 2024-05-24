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
@Table(name = "Auto")
public class Clase_Auto {

    private static final long serialVersionUID = 1L;

    @Column(name = "Id_Auto")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Auto;

    @Column(name = "Matricula", length = 40)
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "Id_Modelo_Fk")
    private Clase_Modelo idModeloFk;

    @ManyToOne
    @JoinColumn(name = "Id_Cliente_Fk")
    private Clase_Cliente idClienteFk;

    public Clase_Auto() {
    }

    public Clase_Auto(Long Id_Auto, String matricula, Clase_Modelo idModeloFk, Clase_Cliente idClienteFk) {
        this.Id_Auto = Id_Auto;
        this.matricula = matricula;
        this.idModeloFk = idModeloFk;
        this.idClienteFk = idClienteFk;
    }

    public Long getId_Auto() {
        return Id_Auto;
    }

    public void setId_Auto(Long Id_Auto) {
        this.Id_Auto = Id_Auto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula.toUpperCase();
    }

    public Clase_Modelo getIdModeloFk() {
        return idModeloFk;
    }

    public void setIdModeloFk(Clase_Modelo idModeloFk) {
        this.idModeloFk = idModeloFk;
    }

    public Clase_Cliente getIdClienteFk() {
        return idClienteFk;
    }

    public void setIdClienteFk(Clase_Cliente idClienteFk) {
        this.idClienteFk = idClienteFk;
    }

}
