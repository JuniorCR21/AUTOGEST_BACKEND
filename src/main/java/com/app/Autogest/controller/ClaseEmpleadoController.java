/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Empleado;
import com.app.Autogest.services.IClaseEmpleadoService;
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
public class ClaseEmpleadoController {
    @Autowired
    private IClaseEmpleadoService empleadoService;
    
    @GetMapping("/MostrarEmpelado")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public List<Clase_Empleado> index() {
        return empleadoService.findAll();
    }
    
    @PostMapping("/InsertarEmpleado")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Empleado empleado, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {

                Clase_Empleado insertarEmpleado = empleadoService.insert(empleado);
                if (insertarEmpleado != null) {
                    response.put("message", "Empleado insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Empleado");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Empelado: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/BuscarEmpleado/{id_Empleado}")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public Clase_Empleado buscar(@PathVariable Long id_Empleado) {
        return empleadoService.findById(id_Empleado);
    }


    @PutMapping("/ActualizarEmpleado/{id_Empleado}")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id_Empleado, @RequestBody Clase_Empleado empleado) {
        Map<String, String> response = new HashMap<>();
        try {
            empleado.setId_Empleado(id_Empleado);
            empleadoService.update(empleado);
            response.put("message", "Empleado actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Empleado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/BuscarEmpleadoPorNombre/{nombre}")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
        List<Clase_Empleado> empleadoEncontradas = empleadoService.findByNombre(nombre);
        Map<String, Object> response = new HashMap<>();
        if (!empleadoEncontradas.isEmpty()) {
            return new ResponseEntity<>(empleadoEncontradas, HttpStatus.OK);
        } else {
            response.put("message", "Empleado no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
