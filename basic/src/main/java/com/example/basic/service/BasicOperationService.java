package com.example.basic.service;

import localhost._8080.entity.CreateProductRequest;
import localhost._8080.entity.CreateProductResponse;
import localhost._8080.entity.GetAllProducts;
import localhost._8080.entity.GetProductByIdResponse;
import localhost._8080.entity.GetProductsByFilterRequest;
import localhost._8080.entity.GetProductsByFilterResponse;
import localhost._8080.entity.UpdateProductByIdRequest;
import localhost._8080.entity.UpdateProductByIdResponse;

public interface BasicOperationService {
    GetAllProducts getAllProducts();

    GetProductByIdResponse getProductById(Integer id);

    public GetProductsByFilterResponse getProductsByFilter(GetProductsByFilterRequest getProductsByFilterRequest);

    CreateProductResponse createProduct(CreateProductRequest createProductRequest);

    UpdateProductByIdResponse updateProductById(UpdateProductByIdRequest updateProductByIdRequest);

    void deleteProductById(Integer id);
}
