/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;


import com.app.Autogest.entity.Clase_Empleado;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseEmpleadoService {
    List<Clase_Empleado> findAll();
    Clase_Empleado insert(Clase_Empleado empleado);
    Clase_Empleado update(Clase_Empleado empleado);
    List<Clase_Empleado> findByNombre (String nombres);
    Clase_Empleado findById (Long id);
}
