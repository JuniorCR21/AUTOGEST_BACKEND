/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.Globales;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author CLAUDIO CRUZADO
 */

@ControllerAdvice
public class GlobalExceptionhHandler {
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Verificar si el usuario no está autenticado
        if (authentication instanceof AnonymousAuthenticationToken) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No estás logueado");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        // Usuario autenticado pero no tiene permisos
        Map<String, String> response = new HashMap<>();
        response.put("message", "No tiene permisos para acceder a esta funcionalidad");
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
    
}
