/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;

import com.app.Autogest.entity.Clase_Tipo_Documento;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseTipoDocumentoService {
    List<Clase_Tipo_Documento> findAll();
    Clase_Tipo_Documento insert(Clase_Tipo_Documento tipo);
    Clase_Tipo_Documento update(Clase_Tipo_Documento tipo);
    Clase_Tipo_Documento findById (Long id_Tipo);
}
