package com.example.basic.controller;

import com.example.basic.service.impl.BasicOperationServiceImpl;
import localhost._8080.entity.CreateProductRequest;
import localhost._8080.entity.CreateProductResponse;
import localhost._8080.entity.DeleteProductByIdRequest;
import localhost._8080.entity.GetAllProducts;
import localhost._8080.entity.GetProductByIdRequest;
import localhost._8080.entity.GetProductByIdResponse;
import localhost._8080.entity.GetProductsByFilterRequest;
import localhost._8080.entity.GetProductsByFilterResponse;
import localhost._8080.entity.Ping;
import localhost._8080.entity.UpdateProductByIdRequest;
import localhost._8080.entity.UpdateProductByIdResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Slf4j
@Endpoint
public class BasicOperationController {

    private static final String NAMESPACE_URI = "http://localhost:8080/Entity";

    @Autowired
    private BasicOperationServiceImpl basicOperationService;

    @PayloadRoot(namespace = "http://localhost:8080/Entity", localPart = "ping")
    @ResponsePayload
    public Ping ping() {
        Ping ping = new Ping();
        ping.setPing("pong");
        return ping;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProducts")
    @ResponsePayload
    public GetAllProducts getAllProducts() {
        return basicOperationService.getAllProducts();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getProductById(@RequestPayload GetProductByIdRequest getProductByIdRequest) {
        return basicOperationService.getProductById(getProductByIdRequest.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsByFilterRequest")
    @ResponsePayload
    public GetProductsByFilterResponse getProductsByFilter(@RequestPayload GetProductsByFilterRequest getProductsByFilterRequest) {
        return basicOperationService.getProductsByFilter(getProductsByFilterRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createProductRequest")
    @ResponsePayload
    public CreateProductResponse createProduct(@RequestPayload CreateProductRequest createProductRequest) {
        return basicOperationService.createProduct(createProductRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductByIdRequest")
    @ResponsePayload
    public UpdateProductByIdResponse updateProductById(@RequestPayload UpdateProductByIdRequest updateProductByIdRequest) {
        return basicOperationService.updateProductById(updateProductByIdRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductByIdRequest")
    @ResponsePayload
    public void deleteProductById(@RequestPayload DeleteProductByIdRequest deleteProductByIdRequest) {
        basicOperationService.deleteProductById(deleteProductByIdRequest.getId());
    }

}
