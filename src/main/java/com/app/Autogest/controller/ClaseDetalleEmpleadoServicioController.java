/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Detalle_Empleado_Servicio;
import com.app.Autogest.services.IClaseDetalleEmpleadoServicioService;
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
import org.springframework.web.bind.annotation.PostMapping;
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
public class ClaseDetalleEmpleadoServicioController {

    @Autowired
    private IClaseDetalleEmpleadoServicioService detalleempleadoservicioService;

    @GetMapping("/MostrarDetalleEmpeladoServicio")
    private List<Clase_Detalle_Empleado_Servicio> index() {
        return detalleempleadoservicioService.findAll();
    }


    @PostMapping("/InsertarDetalleEmpleadoServicio")
    private ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Detalle_Empleado_Servicio detalleempleadoservicio, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {

                Clase_Detalle_Empleado_Servicio insertarDetalleEmpleadoServicio = detalleempleadoservicioService.insert(detalleempleadoservicio);
                if (insertarDetalleEmpleadoServicio != null) {
                    response.put("message", "Detalle Empleado Servicio insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Detalle Empleado Servicio");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Detalle Empleado Servicio: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
