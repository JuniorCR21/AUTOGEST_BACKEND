/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseFamiliaDao;
import com.app.Autogest.entity.Clase_Familia;
import com.app.Autogest.services.IClaseFamiliaService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseFamiliaServicesImpl implements IClaseFamiliaService{

    @Autowired
    private IClaseFamiliaDao familiaDao;
    
    @Override
    public List<Clase_Familia> findAll() {
       return (List<Clase_Familia>) familiaDao.findAll();
    }
    
    @Override
    @Transactional
    public Clase_Familia insert(Clase_Familia familia) {
        return familiaDao.save(familia);
    }

    @Override
    public Clase_Familia update(Clase_Familia familia) {
        if (familia.getId_Familia()!= null && familiaDao.existsById(familia.getId_Familia())) {
            return familiaDao.save(familia);
        }
        return null;
    }

    @Override
    public Clase_Familia findById(Long id) {
        return familiaDao.findById(id).orElse(null);
    }
    

    
}
