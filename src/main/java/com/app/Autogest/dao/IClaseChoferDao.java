/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.dao;


import com.app.Autogest.entity.Clase_Chofer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseChoferDao extends JpaRepository<Clase_Chofer, Long>{
    List<Clase_Chofer> findByNombresContainingIgnoreCase(String nombres);
}
 