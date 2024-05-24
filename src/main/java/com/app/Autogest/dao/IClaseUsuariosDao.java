/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.Autogest.dao;

import com.app.Autogest.entity.Clase_Usuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Repository
public interface IClaseUsuariosDao extends JpaRepository<Clase_Usuarios, Long>{
    Optional<Clase_Usuarios> findUsuarioByUsername(String username);
     List<Clase_Usuarios> findByUsername(String username);
}
