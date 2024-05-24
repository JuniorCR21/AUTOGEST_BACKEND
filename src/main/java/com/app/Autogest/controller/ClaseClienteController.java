/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Cliente;
import com.app.Autogest.services.IClaseClienteService;
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
//@PreAuthorize("denyAll()")
public class ClaseClienteController {

    @Autowired
    private IClaseClienteService clienteService;

    @GetMapping("/MostrarCliente")
//    @PreAuthorize("hasAnyAuthority('BASICO')")
    public List<Clase_Cliente> index() {
        return clienteService.findAll();
    }

    @PostMapping("/InsertarCliente")
    private ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Cliente cliente, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                Clase_Cliente existingCliente = clienteService.findByRuc(cliente.getRuc());
                if (existingCliente != null) {
                    response.put("message", "El cliente ya existe");
                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                }

                Clase_Cliente insertedCliente = clienteService.insert(cliente);
                if (insertedCliente != null) {
                    response.put("message", "Cliente insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar el cliente");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar el cliente: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/BuscarCliente/{id_Cliente}")
    private Clase_Cliente buscar(@PathVariable Long id_Cliente) {
        return clienteService.findById(id_Cliente);
    }

    @PutMapping("/ActualizarCliente/{id_Cliente}")
    private ResponseEntity<Map<String, String>> update(@PathVariable Long id_Cliente, @RequestBody Clase_Cliente cliente) {
        Map<String, String> response = new HashMap<>();
        try {
            cliente.setId_Cliente(id_Cliente);
            clienteService.update(cliente);
            response.put("message", "Cliente actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Cliente");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/buscarPorRuc/{ruc}")
    public ResponseEntity<?> buscarPorRuc(@PathVariable String ruc) {
        Clase_Cliente cliente = clienteService.findByRuc(ruc);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No se encontró ningún Cliente");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
