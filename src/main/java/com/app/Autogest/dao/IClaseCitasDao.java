/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.dao;

import com.app.Autogest.entity.Clase_Citas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author CLAUDIO CRUZADO
 */
public interface IClaseCitasDao extends JpaRepository<Clase_Citas, Long> {

    @Query("SELECT c FROM Clase_Citas c " +
           "JOIN c.id_Auto_Fk a " +
           "JOIN a.idClienteFk cl " +
           "JOIN c.id_Chofer_Fk ch " +
           "WHERE cl.id_Cliente = :idCliente " +
           "ORDER BY c.fecha, c.hora")
    List<Clase_Citas> findCitasByClienteId(@Param("idCliente") Long idCliente);
}
