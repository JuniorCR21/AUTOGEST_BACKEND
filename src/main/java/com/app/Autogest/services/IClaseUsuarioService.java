/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;

import com.app.Autogest.entity.Clase_Usuarios;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseUsuarioService {
    public List<Clase_Usuarios> findAll();
    public Clase_Usuarios insert(Clase_Usuarios usuario);
    public List<Clase_Usuarios> findByUsername(String usaurio);
}
