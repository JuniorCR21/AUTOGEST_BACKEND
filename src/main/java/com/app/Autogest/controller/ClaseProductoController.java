/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Producto;
import com.app.Autogest.services.IClaseProductoService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

public class ClaseProductoController {

    @Autowired
    private IClaseProductoService productoService;

    @GetMapping("/MostrarProducto")
    private List<Clase_Producto> index() {
        return productoService.findAll();
    }

    @PostMapping("/InsertarProducto")
    private ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Producto producto, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {

                Clase_Producto insertarProducto = productoService.insert(producto);
                if (insertarProducto != null) {
                    response.put("message", "Producto insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Producto");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Producto: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/BuscarProducto/{id_Producto}")
    private Clase_Producto buscar(@PathVariable Long id_Producto) {
        return productoService.findById(id_Producto);
    }
    
    @PutMapping("/ActualizarProducto/{id_Producto}")
    private ResponseEntity<Map<String, String>> update(@PathVariable Long id_Producto, @RequestBody Clase_Producto producto) {
        Map<String, String> response = new HashMap<>();
        try {
            producto.setId_Producto(id_Producto);
            productoService.update(producto);
            response.put("message", "Producto actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Producto");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/BuscarProductoPorNombre/{nombre}")
    private ResponseEntity<?> buscarPorMarca(@PathVariable String nombre) {
        List<Clase_Producto> productosEncontrados = productoService.findByNombre(nombre);
        Map<String, Object> response = new HashMap<>();
        if (!productosEncontrados.isEmpty()) {
            return new ResponseEntity<>(productosEncontrados, HttpStatus.OK);
        } else {
            response.put("message", "Producto no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    
}
