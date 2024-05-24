/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller;

import com.app.Autogest.dao.IClaseUsuariosDao;
import com.app.Autogest.entity.Clase_Usuarios;
import com.app.Autogest.services.IClaseUsuarioService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@PreAuthorize("denyAll()")
public class ClaseUsuariosController {

    @Autowired
    private IClaseUsuarioService usuariosService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IClaseUsuariosDao usuarioDao;

    @GetMapping("/MostrarUsuarios")
    @PreAuthorize("hasRole('DEVELOPER')")
    public List<Clase_Usuarios> index() {
        return usuariosService.findAll();
    }

    @PostMapping("/InsertarUsuarios")
    @PreAuthorize("hasRole('DEVELOPER')")
    public ResponseEntity<Map<String, String>> insert(@Valid @RequestBody Clase_Usuarios usuarios, BindingResult bindingResult) {
        Map<String, String> response = new HashMap();

        try {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    response.put(error.getField(), error.getDefaultMessage());
                }
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                String encryptedPassword = passwordEncoder.encode(usuarios.getPassword());
                usuarios.setPassword(encryptedPassword);
                Clase_Usuarios insertarUsuarios = usuariosService.insert(usuarios);
                if (insertarUsuarios != null) {
                    response.put("message", "Usuario insertado Correctamente");
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    response.put("message", "Error al insertar Usuario");
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            response.put("error", "Error al insertar Usuario : " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/hello/{usuario}")
    @PreAuthorize("hasAnyAuthority('INTERMEDIO' ,'BASICO','CLIENTE')")
    public ResponseEntity<?> buscarUsuario(@PathVariable String usuario) {
        List<Clase_Usuarios> marcasEncontradas = usuariosService.findByUsername(usuario);
        Map<String, Object> response = new HashMap<>();
        if (!marcasEncontradas.isEmpty()) {
            return new ResponseEntity<>(marcasEncontradas, HttpStatus.OK);
        } else {
            response.put("message", "Usuario no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    
    
}
