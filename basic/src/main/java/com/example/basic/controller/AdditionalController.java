package com.example.basic.controller;

import com.example.basic.service.impl.AdditionalService;
import com.example.objects.basic.request.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdditionalController {

    @Autowired
    private AdditionalService additionalService;

    @GetMapping("/ping")
    public ResponseEntity<?> isAlive() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(additionalService.getAllProducts(), HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Integer id, @RequestBody ProductRequestDto product) {
        return new ResponseEntity<>(additionalService.updateProductById(id, product), HttpStatus.OK);
    }

}
