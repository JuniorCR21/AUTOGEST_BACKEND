/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;


import com.app.Autogest.dao.IClaseTipoDocumentoDao;
import com.app.Autogest.entity.Clase_Tipo_Documento;
import com.app.Autogest.services.IClaseTipoDocumentoService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseTipoDocumentoServicesImpl implements IClaseTipoDocumentoService{

    @Autowired
    private IClaseTipoDocumentoDao tipodocumentoDao;
    
    @Override
    public List<Clase_Tipo_Documento> findAll() {
       return (List<Clase_Tipo_Documento>) tipodocumentoDao.findAll();
    }
    
    @Override
    @Transactional
    public Clase_Tipo_Documento insert(Clase_Tipo_Documento tipodocumento) {
        return tipodocumentoDao.save(tipodocumento);
    }

    @Override
    public Clase_Tipo_Documento update(Clase_Tipo_Documento tipodocumento) {
        if (tipodocumento.getId_Tipo_Documento()!= null && tipodocumentoDao.existsById(tipodocumento.getId_Tipo_Documento())) {
            return tipodocumentoDao.save(tipodocumento);
        }
        return null;
    }

    @Override
    public Clase_Tipo_Documento findById(Long id_Tipo) {
        return tipodocumentoDao.findById(id_Tipo).orElse(null);
    }
    

    
}
