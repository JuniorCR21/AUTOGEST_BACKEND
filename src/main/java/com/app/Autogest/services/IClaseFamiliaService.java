/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;

import com.app.Autogest.entity.Clase_Familia;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseFamiliaService {
    List<Clase_Familia> findAll();
    Clase_Familia insert(Clase_Familia familia);
    Clase_Familia update(Clase_Familia familia);
    
    Clase_Familia findById(Long id);
}
