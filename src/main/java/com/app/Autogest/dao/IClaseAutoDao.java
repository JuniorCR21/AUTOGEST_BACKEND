/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.dao;


import com.app.Autogest.entity.Clase_Auto;
import com.app.Autogest.entity.Clase_Cliente;
import com.app.Autogest.entity.Clase_Modelo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseAutoDao extends JpaRepository<Clase_Auto, Long>{
    List<Clase_Auto> findByidModeloFk(Clase_Modelo modelo);
    public Clase_Auto findByMatricula(String matricula);
     List<Clase_Auto> findByidClienteFk(Clase_Cliente cliente);
     Clase_Auto findByMatriculaAndIdClienteFk(String matricula, Clase_Cliente cliente);
}
