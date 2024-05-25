/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;


import com.app.Autogest.entity.Clase_Citas;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseCitasService {
    List<Clase_Citas> findAll();
    Clase_Citas insert(Clase_Citas citas);
    Clase_Citas update(Clase_Citas citas);
    Clase_Citas findById(Long id);
    public List<Clase_Citas> findByClienteId(Long idCliente);
}
