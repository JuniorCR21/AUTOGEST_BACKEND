/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;

import com.app.Autogest.dao.IClaseOrdenIngresoDao;
import com.app.Autogest.entity.Clase_Orden_Ingreso;
import com.app.Autogest.services.IClaseOrdenIngresoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseOrdenIngresoServicesImpl implements IClaseOrdenIngresoService{

    @Autowired
    private IClaseOrdenIngresoDao ordenDao;
    
    @Override
    public List<Clase_Orden_Ingreso> findAll() {
       return (List<Clase_Orden_Ingreso>) ordenDao.findAll();
    }

    @Override
    public Clase_Orden_Ingreso insert(Clase_Orden_Ingreso orden) {
        return ordenDao.save(orden);
    }
    
}
