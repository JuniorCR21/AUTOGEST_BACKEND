/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;

import com.app.Autogest.entity.Clase_Detalle_Empleado_Servicio;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseDetalleEmpleadoServicioService {
    public List<Clase_Detalle_Empleado_Servicio> findAll();
    public Clase_Detalle_Empleado_Servicio insert(Clase_Detalle_Empleado_Servicio detalleempleadoservicio);
}
