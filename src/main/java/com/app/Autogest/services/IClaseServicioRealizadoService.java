/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;

import com.app.Autogest.entity.Clase_Servicio_Realizado;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseServicioRealizadoService {
    public List<Clase_Servicio_Realizado> findAll();
    public Clase_Servicio_Realizado insert(Clase_Servicio_Realizado servicio);
}
