/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;


import com.app.Autogest.entity.Clase_Producto;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseProductoService {
    List<Clase_Producto> findAll();
    Clase_Producto insert(Clase_Producto producto);
    Clase_Producto update(Clase_Producto producto);
    Clase_Producto findById (Long id);
    List<Clase_Producto> findByNombre(String nombre);
}
