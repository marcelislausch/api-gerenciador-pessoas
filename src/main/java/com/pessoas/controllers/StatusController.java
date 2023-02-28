/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pessoas.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marceli Lausch
 */
@RestController
public class StatusController {
    
    @GetMapping("/status")
    @ApiOperation(value = "Consultar status da API", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getStatus(){
        return "<h2>API para gestão de pessoas está no ar!<h2>";
    }
    
}
