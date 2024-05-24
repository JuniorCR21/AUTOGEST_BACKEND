/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Citas;
import com.app.Autogest.services.IClaseCitasService;
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
public class ClaseCitasController {

    @Autowired
    private IClaseCitasService citasService;

    @GetMapping("/MostrarCitas")
    @PreAuthorize("hasAnyAuthority('BASICO')")
    public List<Clase_Citas> index() {
        return citasService.findAll();
    }


    @PostMapping("/InsertarCitas")
    @PreAuthorize("hasAnyAuthority('BASICO','CLIENTE')")
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Citas citas, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                Clase_Citas insertarCitas = citasService.insert(citas);
                if (insertarCitas != null) {
                    response.put("message", "Cita insertada correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Cita");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Cita: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/BuscarCitas/{id_Citas}")
    @PreAuthorize("hasAnyAuthority('BASICO','CLIENTE')")
    public Clase_Citas buscar(@PathVariable Long id_Citas) {
        return citasService.findById(id_Citas);
    }

    @PutMapping("/ActualizarCita/{id_Citas}")
    @PreAuthorize("hasAnyAuthority('BASICO','CLIENTE')")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id_Familia, @RequestBody Clase_Citas citas) {
        Map<String, String> response = new HashMap<>();
        try {
            citas.setId_Citas(id_Familia);
            citasService.update(citas);
            response.put("message", "Cita actualizada correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Cita");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
