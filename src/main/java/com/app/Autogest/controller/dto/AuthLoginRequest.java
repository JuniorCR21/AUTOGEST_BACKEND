/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.controller.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author CLAUDIO CRUZADO
 */

public record AuthLoginRequest (@NotBlank String username, 
                                @NotBlank String password){
    
}
