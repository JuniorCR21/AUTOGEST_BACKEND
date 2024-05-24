/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseAutoDao;
import com.app.Autogest.entity.Clase_Auto;
import com.app.Autogest.entity.Clase_Cliente;
import com.app.Autogest.entity.Clase_Modelo;
import com.app.Autogest.services.IClaseAutoService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseAutoServicesImpl implements IClaseAutoService{

    @Autowired
    private IClaseAutoDao autoDao;
    
    @Override
    public List<Clase_Auto> findAll() {
       return (List<Clase_Auto>) autoDao.findAll();
    }
    
    @Override
    @Transactional
    public Clase_Auto insert(Clase_Auto auto) {
        return autoDao.save(auto);
    }

    @Override
    public Clase_Auto update(Clase_Auto auto) {
        if (auto.getId_Auto()!= null && autoDao.existsById(auto.getId_Auto())) {
            return autoDao.save(auto);
        }
        return null;
    }
    

    @Override
    public List<Clase_Auto> findByIdModeloFk(Clase_Modelo modelo) {
        return autoDao.findByidModeloFk(modelo);
    }

    @Override
    public Clase_Auto findById(Long id) {
        return autoDao.findById(id).orElse(null);
    }

    @Override
    public Clase_Auto findByMatricula(String matricula) {
        return autoDao.findByMatricula(matricula);
    }
    
    @Override
    public List<Clase_Auto> findByIdClienteFk(Clase_Cliente cliente) {
        return autoDao.findByidClienteFk(cliente);
    }
    
    @Override
    public Clase_Auto findByMatriculaAndIdClienteFk(String matricula, Clase_Cliente cliente) {
        return autoDao.findByMatriculaAndIdClienteFk(matricula, cliente);
    }
    
}
