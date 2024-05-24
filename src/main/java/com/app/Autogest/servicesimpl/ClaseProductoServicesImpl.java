/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseProductoDao;
import com.app.Autogest.entity.Clase_Producto;
import com.app.Autogest.services.IClaseProductoService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseProductoServicesImpl implements IClaseProductoService{

    @Autowired
    private IClaseProductoDao productoDao;
    
    @Override
    public List<Clase_Producto> findAll() {
       return (List<Clase_Producto>) productoDao.findAll();
    }
    
    @Override
    @Transactional
    public Clase_Producto insert(Clase_Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Clase_Producto update(Clase_Producto producto) {
        if (producto.getId_Producto()!= null && productoDao.existsById(producto.getId_Producto())) {
            return productoDao.save(producto);
        }
        return null;
    }

    @Override
    public Clase_Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public List<Clase_Producto> findByNombre(String nombre) {
        return productoDao.findByNombreContainingIgnoreCase(nombre);
    }


}
