/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Auto;
import com.app.Autogest.entity.Clase_Cliente;
import com.app.Autogest.services.IClaseAutoService;
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
public class ClaseAutoController {

    @Autowired
    private IClaseAutoService autoService;

    @GetMapping("/MostrarAuto")
    @PreAuthorize("hasAnyAuthority('BASICO')")
    public List<Clase_Auto> index() {
        return autoService.findAll();
    }

    @PostMapping("/InsertarAuto")
    @PreAuthorize("hasAnyAuthority('BASICO', 'CLIENTE')")
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Auto auto, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {

                Clase_Auto insertarAuto = autoService.insert(auto);
                if (insertarAuto != null) {
                    response.put("message", "Auto insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Auto");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Auto: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/BuscarAuto/{id_Auto}")
    @PreAuthorize("hasAnyAuthority('BASICO')")
    public Clase_Auto buscar(@PathVariable Long id_Auto) {
        return autoService.findById(id_Auto);
    }

    @PutMapping("/ActualizarAuto/{id_Auto}")
    @PreAuthorize("hasAnyAuthority('BASICO')")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id_Auto, @RequestBody Clase_Auto auto) {
        Map<String, String> response = new HashMap<>();
        try {
            auto.setId_Auto(id_Auto);
            autoService.update(auto);
            response.put("message", "Auto actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Auto");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarPorMatricula/{matricula}")
    @PreAuthorize("hasAnyAuthority('BASICO')")
    public ResponseEntity<?> buscarPorRuc(@PathVariable String matricula) {
        Clase_Auto auto = autoService.findByMatricula(matricula);
        if (auto != null) {
            return ResponseEntity.ok(auto);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No se encontró ningún Auto");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/buscarPorMatriculaYCliente/{matricula}/{idCliente}")
    @PreAuthorize("hasAnyAuthority('BASICO')")
    public ResponseEntity<?> buscarPorMatriculaYCliente(@PathVariable String matricula, @PathVariable Long idCliente) {
        Clase_Cliente cliente = new Clase_Cliente();
        cliente.setId_Cliente(idCliente);
        Clase_Auto auto = autoService.findByMatriculaAndIdClienteFk(matricula, cliente);
        if (auto != null) {
            return ResponseEntity.ok(auto);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No se encontró ningún Auto para la matrícula y cliente especificados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    
    @GetMapping("/buscarAutoPorCliente/{idCliente}")
    @PreAuthorize("hasAnyAuthority('BASICO', 'CLIENTE')")
    public ResponseEntity<?> buscarPorCliente(@PathVariable Long idCliente) {
        Clase_Cliente cliente = new Clase_Cliente();
        cliente.setId_Cliente(idCliente);
        List<Clase_Auto> autos = autoService.findByIdClienteFk(cliente);
        if (!autos.isEmpty()) {
            return ResponseEntity.ok(autos);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No se encontraron Autos para el cliente especificado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    
}
