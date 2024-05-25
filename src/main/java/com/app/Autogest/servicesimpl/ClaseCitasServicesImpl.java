/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;

import com.app.Autogest.dao.IClaseCitasDao;
import com.app.Autogest.entity.Clase_Citas;
import com.app.Autogest.services.IClaseCitasService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseCitasServicesImpl implements IClaseCitasService {

    @Autowired
    private IClaseCitasDao citasDao;

    @Override
    public List<Clase_Citas> findAll() {
        return (List<Clase_Citas>) citasDao.findAll();
    }

    @Override
    @Transactional
    public Clase_Citas insert(Clase_Citas citas) {
        return citasDao.save(citas);
    }

    @Override
    public Clase_Citas update(Clase_Citas citas) {
        if (citas.getId_Citas() != null && citasDao.existsById(citas.getId_Citas())) {
            return citasDao.save(citas);
        }
        return null;
    }

    @Override
    public Clase_Citas findById(Long id) {
        return citasDao.findById(id).orElse(null);
    }
    
    @Override
    public List<Clase_Citas> findByClienteId(Long idCliente) {
        return citasDao.findCitasByClienteId(idCliente);
    }
    

}
