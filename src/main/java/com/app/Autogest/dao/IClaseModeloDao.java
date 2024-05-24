/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.dao;

import com.app.Autogest.entity.Clase_Marca;
import com.app.Autogest.entity.Clase_Modelo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseModeloDao extends JpaRepository<Clase_Modelo, Long>{
    List<Clase_Modelo> findByIdMarcaFK(Clase_Marca marca);
    List<Clase_Modelo> findByModeloContainingIgnoreCase(String modelo);
    List<Clase_Modelo> findByEstado(int estado);
}