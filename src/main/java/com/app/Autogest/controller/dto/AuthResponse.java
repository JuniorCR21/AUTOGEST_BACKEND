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
@JsonPropertyOrder({"username", "message", "jwt", "role", "status"})
public record AuthResponse(
        String username,
        String message,
        String jwt,
        String role,
        boolean status) {

}
