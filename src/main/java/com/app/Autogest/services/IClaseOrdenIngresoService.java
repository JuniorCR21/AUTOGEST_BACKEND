/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;

import com.app.Autogest.entity.Clase_Orden_Ingreso;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseOrdenIngresoService {
    public List<Clase_Orden_Ingreso> findAll();
    public Clase_Orden_Ingreso insert(Clase_Orden_Ingreso orden);
}
