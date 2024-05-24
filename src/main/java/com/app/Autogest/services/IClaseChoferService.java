/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;


import com.app.Autogest.entity.Clase_Chofer;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseChoferService {
    List<Clase_Chofer> findAll();
    Clase_Chofer insert(Clase_Chofer chofer);
    Clase_Chofer update(Clase_Chofer chofer);
    Clase_Chofer findById (Long id);
    List<Clase_Chofer> findByNombres(String nombres);
}
