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
@Table(name = "DetalleEmpleadoServicio")
public class Clase_Detalle_Empleado_Servicio {

    private static final long serialVersionUID = 1L;

    @Column(name = "Id_Detalle_Empleado_Servicio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Detalle_Empleado_Servicio;

    @ManyToOne
    @JoinColumn(name = "Id_Empelado_Fk")
    private Clase_Empleado Id_Empleado_Fk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Servicio_FK")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Clase_Servicio_Realizado Id_Servicio_FK;

}
