/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;


import com.app.Autogest.entity.Clase_Marca;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseMarcaService {
//    List<Clase_Marca> findAll();
    Clase_Marca insert(Clase_Marca marca);// Insertar Marca
    Clase_Marca update(Clase_Marca marca);// Modificar una marca
    Clase_Marca findById(Long id);// Buscar una marca por id, esto va a servicir para el metodo de Modificar, primero busca la marca muestra todos sus atributos y luego se Modifica
    Clase_Marca updateEstado(Long id, int estado);// cambiar el estado de una marca 1(Activos) 0(Inactivos)
    List<Clase_Marca> findByMarca(String marca);// Buscar una marca por el atributo marca
    List<Clase_Marca> findAllByEstado(int estado);// Mostrar solo las marcas que tengan el estado 1(Activos)
}
