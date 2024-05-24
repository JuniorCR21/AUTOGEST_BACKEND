/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.services;

import com.app.Autogest.entity.Clase_Cliente;
import java.util.List;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseClienteService {
    public List<Clase_Cliente> findAll();
    public Clase_Cliente insert(Clase_Cliente cliente);
    public Clase_Cliente update(Clase_Cliente cliente);
    public Clase_Cliente findByRuc(String ruc);
    public Clase_Cliente findById(Long id);
}
