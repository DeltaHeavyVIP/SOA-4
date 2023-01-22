package com.example.gateway.controller;

import com.example.gateway.service.OperationService;
import com.example.objects.basic.request.ProductRequestDto;
import com.example.objects.common.FilterDto;
import com.example.objects.common.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("/ping")
    public ResponseEntity<?> isAlive() {
        return new ResponseEntity<>(operationService.ping(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(operationService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/products/filter")
    public ResponseEntity<List<ProductDto>> getProductsByFilter(@RequestBody FilterDto filter) {
        return new ResponseEntity<>(operationService.getProductsByFilter(filter), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDto product) {
        return new ResponseEntity<>(operationService.createProduct(product), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(operationService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Integer id, @RequestBody ProductRequestDto product) {
        return new ResponseEntity<>(operationService.updateProductById(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id) {
        operationService.deleteProductById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/count/products/price_high_parameter")
    public ResponseEntity<?> countProductsWherePriceHigher(@RequestParam(name = "price") Long price) {
        return new ResponseEntity<>(operationService.countProductsWherePriceHigher(price), HttpStatus.OK);
    }

    @GetMapping("/search/products/name/include/substring")
    public ResponseEntity<?> getArrayProductsWhereNameIncludeSubstring(@RequestParam(name = "subString") String subString) {
        return new ResponseEntity<>(operationService.getArrayProductsWhereNameIncludeSubstring(subString), HttpStatus.OK);
    }

    @GetMapping("/search/products/name/unique")
    public ResponseEntity<?> getArrayProductsWhereNameUnique() {
        return new ResponseEntity<>(operationService.getArrayProductsWhereNameUnique(), HttpStatus.OK);
    }

}