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
@Table(name = "Usuarios")
public class Clase_Usuarios {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Usuarios;
    
    @Column(unique = true)
    private String username;
    private String password;
    
    @Column(name = "is_enabled")
    private boolean isEnabled;
    
    @Column(name = "account_No_Expired")
    private boolean accountNoExpired;
    
    @Column(name = "account_No_Locked")
    private boolean accountNoLocked;
    
    @Column(name = "credential_No_Expired")
    private boolean credentialNoExpired;
    
    @ManyToOne
    @JoinColumn(name = "Id_Empleado_Fk")
    private Clase_Empleado idEmpleadoFK;
    
    @ManyToOne
    @JoinColumn(name = "Id_Cliente_Fk")
    private Clase_Cliente idClienteFK;
    
    @ManyToOne
    @JoinColumn(name = "Id_Roles_Fk")
    private Clase_Roles idRolesFK;
    
    
}
