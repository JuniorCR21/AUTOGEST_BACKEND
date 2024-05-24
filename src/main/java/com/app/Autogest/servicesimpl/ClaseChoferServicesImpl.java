/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseChoferDao;
import com.app.Autogest.entity.Clase_Chofer;
import com.app.Autogest.services.IClaseChoferService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseChoferServicesImpl implements IClaseChoferService{

    @Autowired
    private IClaseChoferDao choferDao;
    
    @Override
    public List<Clase_Chofer> findAll() {
       return (List<Clase_Chofer>) choferDao.findAll();
    }
    
    @Override
    @Transactional
    public Clase_Chofer insert(Clase_Chofer chofer) {
        return choferDao.save(chofer);
    }
    
    @Override
    public Clase_Chofer update(Clase_Chofer chofer) {
        if (chofer.getId_Chofer()!= null && choferDao.existsById(chofer.getId_Chofer())) {
            return choferDao.save(chofer);
        }
        return null; 
    }

    @Override
    public Clase_Chofer findById(Long id) {
        return choferDao.findById(id).orElse(null);
    }

    @Override
    public List<Clase_Chofer> findByNombres(String nombres) {
        return choferDao.findByNombresContainingIgnoreCase(nombres);
    }
    
}
