/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@JsonPropertyOrder({"username", "message", "jwt", "role", "status", "cliente", "cliente_razon", "empleado"})
public record AuthResponse(
        String username,
        String message,
        String jwt,
        String role,
        Long cliente,
        Long empleado,
        String cliente_razon,
        boolean status) {

}
