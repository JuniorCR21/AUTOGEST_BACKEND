/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;

import com.app.Autogest.dao.IClaseModeloDao;
import com.app.Autogest.entity.Clase_Marca;
import com.app.Autogest.entity.Clase_Modelo;
import com.app.Autogest.services.IClaseModeloService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseModeloServicesImpl implements IClaseModeloService{

    @Autowired
    private IClaseModeloDao modeloDao;
    
    
    @Override
    public List<Clase_Modelo> findAllByEstado(int estado) {
        return modeloDao.findByEstado(estado);
    }
    
    @Override
    @Transactional
    public Clase_Modelo insert(Clase_Modelo modelo) {
        return modeloDao.save(modelo);
    }

    @Override
    public Clase_Modelo update(Clase_Modelo modelo) {
        if (modelo.getId_Modelo()!= null && modeloDao.existsById(modelo.getId_Modelo())) {
            return modeloDao.save(modelo);
        }
        return null;
    }

    @Override
    public List<Clase_Modelo> findByMarca(Clase_Marca marca) {
        return modeloDao.findByIdMarcaFK(marca);
    }

    @Override
    public Clase_Modelo findById(Long id) {
        return modeloDao.findById(id).orElse(null);
    }

    @Override
    public Clase_Modelo updateEstado(Long id, int estado) {
        Clase_Modelo modelo = modeloDao.findById(id).orElse(null);
        if (modelo != null) {
            modelo.setEstado(estado);
            return modeloDao.save(modelo);
        }
        return null;
    }

    @Override
    public List<Clase_Modelo> findByModelo(String modelo) {
        return modeloDao.findByModeloContainingIgnoreCase(modelo);
    }

    
}
