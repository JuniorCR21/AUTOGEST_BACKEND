/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;


import com.app.Autogest.entity.Clase_Marca;
import com.app.Autogest.entity.Clase_Modelo;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseModeloService {
//    public List<Clase_Modelo> findAll();
    List<Clase_Modelo> findAllByEstado(int estado);
    
    public Clase_Modelo insert(Clase_Modelo modelo);
    
    Clase_Modelo findById(Long id);
    public Clase_Modelo update(Clase_Modelo modelo);
    
    List<Clase_Modelo> findByMarca(Clase_Marca marca);
    
    List<Clase_Modelo> findByModelo(String modelo);
    
    Clase_Modelo updateEstado(Long id, int estado);
}
