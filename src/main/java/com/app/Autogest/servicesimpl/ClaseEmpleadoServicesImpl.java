/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseEmpeladoDao;
import com.app.Autogest.entity.Clase_Empleado;
import com.app.Autogest.services.IClaseEmpleadoService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseEmpleadoServicesImpl implements IClaseEmpleadoService{

    @Autowired
    private IClaseEmpeladoDao empleadoDao;
    
    @Override
    public List<Clase_Empleado> findAll() {
       return (List<Clase_Empleado>) empleadoDao.findAll();
    }
    
    @Override
    @Transactional
    public Clase_Empleado insert(Clase_Empleado empelado) {
        return empleadoDao.save(empelado);
    }
    
    @Override
    public Clase_Empleado update(Clase_Empleado empelado) {
        if (empelado.getId_Empleado()!= null && empleadoDao.existsById(empelado.getId_Empleado())) {
            return empleadoDao.save(empelado);
        }
        return null;
    }

    @Override
    public List<Clase_Empleado> findByNombre(String nombres) {
       return empleadoDao.findByNombresContainingIgnoreCase(nombres);
    }

    @Override
    public Clase_Empleado findById(Long id) {
       return empleadoDao.findById(id).orElse(null);
    }
    
}
