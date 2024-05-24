/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Marca;
import com.app.Autogest.entity.Clase_Modelo;
import com.app.Autogest.services.IClaseMarcaService;
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
// *
 * @author CLAUDIO CRUZADO
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Autogest")
//@PreAuthorize("denyAll()")
public class ClaseMarcaController {

    @Autowired
    private IClaseMarcaService marcaService;

    @Autowired
    private IClaseModeloService modeloService;

    @GetMapping("/MostrarMarca")
//    @PreAuthorize("hasAnyAuthority('BASICO', 'CLIENTE')")
    public ResponseEntity<?> index() {
        List<Clase_Marca> marcasActivas = marcaService.findAllByEstado(1);
        if (!marcasActivas.isEmpty()) {
            return new ResponseEntity<>(marcasActivas, HttpStatus.OK);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No se encontraron marcas activas");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/BuscarMarca/{id_Marca}")
//    @PreAuthorize("hasAnyAuthority('AVANZADO')")
    public Clase_Marca buscar(@PathVariable Long id_Marca) {
        return marcaService.findById(id_Marca);
    }

    @PostMapping("/InsertarMarca")
//    @PreAuthorize("hasAnyAuthority('AVANZADO')")
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Marca marca, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                marca.setEstado(1);
                Clase_Marca insertarMarca = marcaService.insert(marca);
                if (insertarMarca != null) {
                    response.put("message", "Marca insertada correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar la Marca");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar la Marca: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ActualizarMarca/{id_Marca}")
//    @PreAuthorize("hasAnyAuthority('AVANZADO')")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id_Marca, @RequestBody Clase_Marca marca) {
        Map<String, String> response = new HashMap<>();
        try {
            marca.setEstado(1);
            marca.setId_Marca(id_Marca);
            marcaService.update(marca);
            response.put("message", "Marca actualizada correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Marca");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/EliminarMarca/{id_Marca}")
//    @PreAuthorize("hasAnyAuthority('AVANZADO')")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable Long id_Marca) {
        Map<String, String> response = new HashMap<>();
        try {
            Clase_Marca marca = marcaService.findById(id_Marca);
            if (marca != null) {
                // Verificar si hay modelos asociados a esta marca
                List<Clase_Modelo> modelosAsociados = modeloService.findByMarca(marca);
                if (!modelosAsociados.isEmpty()) {
                    response.put("message", "No se puede eliminar la marca porque hay modelos asociados.");
                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                } else {
                    marcaService.updateEstado(id_Marca, 0);
                    response.put("message", "Marca eliminada correctamente");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            } else {
                response.put("message", "Marca no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("message", "Error al eliminar la Marca");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/BuscarPorMarca/{marca}")
//    @PreAuthorize("hasAnyAuthority('MASTER')")
    public ResponseEntity<?> buscarPorMarca(@PathVariable String marca) {
        List<Clase_Marca> marcasEncontradas = marcaService.findByMarca(marca);
        Map<String, Object> response = new HashMap<>();
        if (!marcasEncontradas.isEmpty()) {
            return new ResponseEntity<>(marcasEncontradas, HttpStatus.OK);
        } else {
            response.put("message", "Marca no encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
