/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseDetalleEmpleadoServicioDao;
import com.app.Autogest.entity.Clase_Detalle_Empleado_Servicio;
import com.app.Autogest.services.IClaseDetalleEmpleadoServicioService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseDetalleEmpleadoServicioServicesImpl implements IClaseDetalleEmpleadoServicioService{

    @Autowired
    private IClaseDetalleEmpleadoServicioDao detalleempleadoservicioDao;
    
    @Override
    public List<Clase_Detalle_Empleado_Servicio> findAll() {
       return (List<Clase_Detalle_Empleado_Servicio>) detalleempleadoservicioDao.findAll();
    }
    
    @Override
    @Transactional
    public Clase_Detalle_Empleado_Servicio insert(Clase_Detalle_Empleado_Servicio detallemepleadoservicio) {
        return detalleempleadoservicioDao.save(detallemepleadoservicio);
    }

    
}
