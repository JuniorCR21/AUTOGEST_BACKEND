/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Chofer;
import com.app.Autogest.services.IClaseChoferService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Autogest")
@PreAuthorize("denyAll()")
public class ClaseChoferController {
    @Autowired
    private IClaseChoferService choferService;
    
    @GetMapping("/MostrarChofer")
    @PreAuthorize("hasAnyAuthority('BASICO','CLIENTE')")
    public List<Clase_Chofer> index() {
        return choferService.findAll();
    }
    
    @PostMapping("/InsertarChofer")
    @PreAuthorize("hasAnyAuthority('BASICO','CLIENTE')")
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Chofer chofer, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                
                Clase_Chofer choferTipoDoc = choferService.insert(chofer);
                if (choferTipoDoc != null) {
                    response.put("message", "Chofer insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Chofer");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Chofer: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/BuscarChofer/{id_Chofer}")
    @PreAuthorize("hasAnyAuthority('BASICO','CLIENTE')")
    public Clase_Chofer buscar(@PathVariable Long id_Chofer) {
        return choferService.findById(id_Chofer);
    }


    @PutMapping("/ActualizarChofer/{id_Chofer}")
    @PreAuthorize("hasAnyAuthority('BASICO','CLIENTE')")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id_Chofer, @RequestBody Clase_Chofer chofer) {
        Map<String, String> response = new HashMap<>();
        try {
            chofer.setId_Chofer(id_Chofer);
            choferService.update(chofer);
            response.put("message", "Chofer actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Chofer");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/BuscarPorNombre/{nombre}")
    @PreAuthorize("hasAnyAuthority('BASICO','CLIENTE')")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
        List<Clase_Chofer> choferesEncontrados = choferService.findByNombres(nombre);
        Map<String, Object> response = new HashMap<>();
        if (!choferesEncontrados.isEmpty()) {
            return new ResponseEntity<>(choferesEncontrados, HttpStatus.OK);
        } else {
            response.put("message", "Chofer no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
}
