/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Familia;
import com.app.Autogest.services.IClaseFamiliaService;
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
public class ClaseFamiliaController {

    @Autowired
    private IClaseFamiliaService familiaService;

    @GetMapping("/MostrarFamilia")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public List<Clase_Familia> index() {
        return familiaService.findAll();
    }

    @PostMapping("/InsertarFamilia")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Familia familia, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                familia.setEstado(1);
                Clase_Familia insertarFamilia = familiaService.insert(familia);
                if (insertarFamilia != null) {
                    response.put("message", "Familia insertada correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Familia");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Familia: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/BuscarFamilia/{id_Familia}")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public Clase_Familia buscar(@PathVariable Long id_Familia) {
        return familiaService.findById(id_Familia);
    }

    @PutMapping("/ActualizarFamilia/{id_Familia}")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id_Familia, @RequestBody Clase_Familia familia) {
        Map<String, String> response = new HashMap<>();
        try {
            familia.setEstado(1);
            familia.setId_Familia(id_Familia);
            familiaService.update(familia);
            response.put("message", "Familia actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Familia");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
