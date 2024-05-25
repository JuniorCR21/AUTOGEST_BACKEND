/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Auto;
import com.app.Autogest.entity.Clase_Modelo;
import com.app.Autogest.services.IClaseAutoService;
import com.app.Autogest.services.IClaseModeloService;
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
public class ClaseModeloController {

    @Autowired
    private IClaseModeloService modeloService;

    @Autowired
    private IClaseAutoService autoService;

    @GetMapping("/MostrarModelo")
    @PreAuthorize("hasAnyAuthority('BASICO', 'CLIENTE')")
    public ResponseEntity<?> index() {
        List<Clase_Modelo> modeloActivos = modeloService.findAllByEstado(1);
        if (!modeloActivos.isEmpty()) {
            return new ResponseEntity<>(modeloActivos, HttpStatus.OK);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No se encontraron modelos activas");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/InsertarModelo")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Modelo modelo, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                modelo.setEstado(1);
                Clase_Modelo insertarModelo = modeloService.insert(modelo);
                if (insertarModelo != null) {
                    response.put("message", "Modelo insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Modelo");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Modelo: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/BuscarModelo/{id_Modelo}")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public Clase_Modelo buscar(@PathVariable Long id_Modelo) {
        return modeloService.findById(id_Modelo);
    }

    @PutMapping("/ActualizarModelo/{id_Modelo}")
    @PreAuthorize("hasAnyAuthority('MASTER')")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id_Modelo, @RequestBody Clase_Modelo modelo) {
        Map<String, String> response = new HashMap<>();
        try {
            modelo.setEstado(1);
            modelo.setId_Modelo(id_Modelo);
            modeloService.update(modelo);
            response.put("message", "Modelo actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Modelo");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/BuscarPorModelo/{modelo}")
    @PreAuthorize("hasAnyAuthority('MASTER', 'CLIENTE')")
    public ResponseEntity<?> buscarPorModelo(@PathVariable String modelo) {
        List<Clase_Modelo> modelosEncontradas = modeloService.findByModelo(modelo);
        Map<String, Object> response = new HashMap<>();
        if (!modelosEncontradas.isEmpty()) {
            return new ResponseEntity<>(modelosEncontradas, HttpStatus.OK);
        } else {
            response.put("message", "Modelo no encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/EliminarModelo/{id_Modelo}")
    @PreAuthorize("hasAnyAuthority('AVANZADO')")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable Long id_Modelo) {
        Map<String, String> response = new HashMap<>();
        try {
            Clase_Modelo modelo = modeloService.findById(id_Modelo);
            if (modelo != null) {
                // Verificar si hay modelos asociados a esta marca
                List<Clase_Auto> modelosAsociados = autoService.findByIdModeloFk(modelo);
                if (!modelosAsociados.isEmpty()) {
                    response.put("message", "No se puede eliminar el modelo porque hay autos asociados.");
                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                } else {
                    modeloService.updateEstado(id_Modelo, 0);
                    response.put("message", "Modelo eliminado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            } else {
                response.put("message", "Modelo no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("message", "Error al eliminar la Modelo");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
