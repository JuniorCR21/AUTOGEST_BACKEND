/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;

import com.app.Autogest.dao.IClaseDetalleServicioDao;
import com.app.Autogest.entity.Clase_Detalle_Servicio;
import com.app.Autogest.services.IClaseDetalleServicioService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseDetalleServicioServicesImpl implements IClaseDetalleServicioService{

    @Autowired
    private IClaseDetalleServicioDao detalleservicioDao;
    
    @Override
    public List<Clase_Detalle_Servicio> findAll() {
       return (List<Clase_Detalle_Servicio>) detalleservicioDao.findAll();
    }
    
    @Override
    @Transactional
    public Clase_Detalle_Servicio insert(Clase_Detalle_Servicio detalleservicio) {
        return detalleservicioDao.save(detalleservicio);
    }


    
}
