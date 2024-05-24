/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseServicioRealizadoDao;
import com.app.Autogest.entity.Clase_Servicio_Realizado;
import com.app.Autogest.services.IClaseServicioRealizadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseServicioRealizadoServicesImpl implements IClaseServicioRealizadoService{

    @Autowired
    private IClaseServicioRealizadoDao servicioDao;
    
    @Override
    public List<Clase_Servicio_Realizado> findAll() {
       return (List<Clase_Servicio_Realizado>) servicioDao.findAll();
    }

    @Override
    public Clase_Servicio_Realizado insert(Clase_Servicio_Realizado servicio) {
         return servicioDao.save(servicio);
    }
    
}
