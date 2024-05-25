/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseMarcaDao;
import com.app.Autogest.entity.Clase_Marca;
import com.app.Autogest.services.IClaseMarcaService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseMarcaServicesImpl implements IClaseMarcaService {

    @Autowired
    private IClaseMarcaDao marcaDao;
    
    @Override
    @Transactional
    public Clase_Marca insert(Clase_Marca marca) {
        return marcaDao.save(marca);
    }

    @Override
    public Clase_Marca update(Clase_Marca marca) {
        if (marca.getId_Marca() != null && marcaDao.existsById(marca.getId_Marca())) {
            return marcaDao.save(marca);
        }
        return null;
    }

    @Override
    public Clase_Marca findById(Long id) {
        return marcaDao.findById(id).orElse(null);
    }

    @Override
    public Clase_Marca updateEstado(Long id, int estado) {
        Clase_Marca marca = marcaDao.findById(id).orElse(null);
        if (marca != null) {
            marca.setEstado(estado);
            return marcaDao.save(marca);
        }
        return null;
    }

    @Override
    public List<Clase_Marca> findByMarca(String marca) {
        return marcaDao.findByMarcaContainingIgnoreCase(marca);
    }

    @Override
    public List<Clase_Marca> findAllByEstado(int estado) {
        return marcaDao.findByEstado(estado);
    }

}
