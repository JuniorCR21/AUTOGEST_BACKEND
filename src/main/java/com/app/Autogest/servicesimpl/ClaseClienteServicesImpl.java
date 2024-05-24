/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseClienteDao;
import com.app.Autogest.entity.Clase_Cliente;
import com.app.Autogest.services.IClaseClienteService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseClienteServicesImpl implements IClaseClienteService{

    @Autowired
    private IClaseClienteDao clienteDao;
    
    @Override
    public List<Clase_Cliente> findAll() {
       return (List<Clase_Cliente>) clienteDao.findAll();
    }
    
    @Override
    @Transactional
    public Clase_Cliente insert(Clase_Cliente cliente) {
        return clienteDao.save(cliente);
    }
    
    @Override
    public Clase_Cliente update(Clase_Cliente cliente) {
        if (cliente.getId_Cliente()!= null && clienteDao.existsById(cliente.getId_Cliente())) {
            return clienteDao.save(cliente);
        }
        return null;
    }

    @Override
    public Clase_Cliente findByRuc(String ruc) {
        return clienteDao.findByRuc(ruc);
    }

    @Override
    public Clase_Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }
    
}
