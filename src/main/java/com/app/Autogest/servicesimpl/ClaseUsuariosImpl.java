/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;

import com.app.Autogest.dao.IClaseUsuariosDao;
import com.app.Autogest.entity.Clase_Usuarios;
import com.app.Autogest.services.IClaseUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseUsuariosImpl implements IClaseUsuarioService {

    @Autowired
    private IClaseUsuariosDao usuarioDao;

    @Override
    public List<Clase_Usuarios> findAll() {
        return (List<Clase_Usuarios>) usuarioDao.findAll();
    }
    @Override
    public Clase_Usuarios insert(Clase_Usuarios usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public List<Clase_Usuarios> findByUsername(String usaurio) {
        return usuarioDao.findByUsername(usaurio);
    }
    
}
