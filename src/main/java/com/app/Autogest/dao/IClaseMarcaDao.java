/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.dao;

import com.app.Autogest.entity.Clase_Marca;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseMarcaDao extends JpaRepository<Clase_Marca, Long>{
     List<Clase_Marca> findByMarcaContainingIgnoreCase(String marca);
     List<Clase_Marca> findByEstado(int estado);
}
