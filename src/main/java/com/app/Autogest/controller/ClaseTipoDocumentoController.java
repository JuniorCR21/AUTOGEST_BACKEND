/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.entity.Clase_Tipo_Documento;
import com.app.Autogest.services.IClaseTipoDocumentoService;
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
public class ClaseTipoDocumentoController {

    @Autowired
    private IClaseTipoDocumentoService tipodocumentoService;

    @GetMapping("/MostrarTipoDocumento")
    @PreAuthorize("hasAnyRole('DEVELOPER', 'ADMIN')")
    public List<Clase_Tipo_Documento> index() {
        return tipodocumentoService.findAll();
    }

    @PostMapping("/InsertarTipoDocumento")
    @PreAuthorize("hasAnyRole('DEVELOPER', 'ADMIN')")
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Tipo_Documento tipodoc, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {

                Clase_Tipo_Documento insertarTipoDoc = tipodocumentoService.insert(tipodoc);
                if (insertarTipoDoc != null) {
                    response.put("message", "Tipo de Documento insertado correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar el Tipo de documento");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar el Tipo de documento: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/BuscarTipoDocumento/{id_Tipo}")
    @PreAuthorize("hasAnyRole('DEVELOPER', 'ADMIN')")
    public Clase_Tipo_Documento buscar(@PathVariable Long id_Tipo) {
        return tipodocumentoService.findById(id_Tipo);
    }
    
    @PutMapping("/ActualizarTipoDocumento/{id_Tipo_Documento}")
    @PreAuthorize("hasAnyRole('DEVELOPER', 'ADMIN')")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id_Tipo_Documento, @RequestBody Clase_Tipo_Documento tipodocumento) {
        Map<String, String> response = new HashMap<>();
        try {
            tipodocumento.setId_Tipo_Documento(id_Tipo_Documento);
            tipodocumentoService.update(tipodocumento);
            response.put("message", "Tipo Documento actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al actualizar Tipo Documento");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
