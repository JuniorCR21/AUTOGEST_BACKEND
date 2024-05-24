/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;

import com.app.Autogest.entity.Clase_Auto;
import com.app.Autogest.entity.Clase_Cliente;
import com.app.Autogest.entity.Clase_Modelo;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseAutoService {
    List<Clase_Auto> findAll();
    Clase_Auto insert(Clase_Auto auto);
    Clase_Auto update(Clase_Auto auto);
    Clase_Auto findById(Long id);
    Clase_Auto findByMatricula (String matricula);
    List<Clase_Auto> findByIdModeloFk(Clase_Modelo modelo);
    List<Clase_Auto> findByIdClienteFk(Clase_Cliente cliente);
    Clase_Auto findByMatriculaAndIdClienteFk(String matricula, Clase_Cliente cliente);
}
