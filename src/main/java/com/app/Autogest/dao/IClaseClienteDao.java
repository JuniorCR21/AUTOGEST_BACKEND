/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.dao;

import com.app.Autogest.entity.Clase_Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseClienteDao extends JpaRepository<Clase_Cliente, Long>{
    public Clase_Cliente findByRuc(String ruc);
}