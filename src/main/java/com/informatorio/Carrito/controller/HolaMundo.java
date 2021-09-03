package com.informatorio.Carrito.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/")
@RestController
public class HolaMundo {
    
    @GetMapping 
    public ResponseEntity<?> hola(){
        return new ResponseEntity<>("holaMundo", HttpStatus.OK);
    }
}
