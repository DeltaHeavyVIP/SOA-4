package com.example.gateway.service;

import com.example.gateway.utils.ModelMapper;
import com.example.objects.basic.request.ProductRequestDto;
import com.example.objects.basic.response.AmountResponseDto;
import com.example.objects.common.FilterDto;
import com.example.objects.common.ProductDto;
import entity.CountProductsWherePriceHigherRequest;
import entity.CountProductsWherePriceHigherResponse;
import entity.CreateProductResponse;
import entity.DeleteProductByIdRequest;
import entity.GetAllProducts;
import entity.GetArrayProductsWhereNameIncludeSubstringRequest;
import entity.GetArrayProductsWhereNameIncludeSubstringResponse;
import entity.GetArrayProductsWhereNameUnique;
import entity.GetProductByIdRequest;
import entity.GetProductByIdResponse;
import entity.GetProductsByFilterResponse;
import entity.Ping;
import entity.UpdateProductByIdResponse;
import lombok.Setter;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;
import java.util.stream.Collectors;

public class OperationService extends WebServiceGatewaySupport {

    @Setter
    private ModelMapper mapper;

    public String ping() {
        Ping pingRequest = new Ping();
        Ping pingResponse = (Ping) getWebServiceTemplate().marshalSendAndReceive(pingRequest);
        return pingResponse.getPing();
    }

    public List<ProductDto> getAllProducts() {
        GetAllProducts getAllProductsRequest = new GetAllProducts();
        GetAllProducts getAllProductsResponse = (GetAllProducts) getWebServiceTemplate().marshalSendAndReceive(getAllProductsRequest);

        return getAllProductsResponse.getProducts().stream().map(mapper::map).collect(Collectors.toList());
    }

    public ProductDto getProductById(Integer id) {
        GetProductByIdRequest getProductByIdRequest = new GetProductByIdRequest();
        getProductByIdRequest.setId(id);
        GetProductByIdResponse getProductByIdResponse = (GetProductByIdResponse) getWebServiceTemplate().marshalSendAndReceive(getProductByIdRequest);
        return mapper.map(getProductByIdResponse.getProduct());
    }

    public List<ProductDto> getProductsByFilter(FilterDto filterRequestDto) {
        GetProductsByFilterResponse getProductsByFilterResponse = (GetProductsByFilterResponse) getWebServiceTemplate().marshalSendAndReceive(mapper.map(filterRequestDto));
        return getProductsByFilterResponse.getProducts().stream().map(mapper::map).collect(Collectors.toList());
    }

    public ProductDto createProduct(ProductRequestDto productDto) {
        CreateProductResponse createProductResponse = (CreateProductResponse) getWebServiceTemplate().marshalSendAndReceive(mapper.map(productDto));
        return mapper.map(createProductResponse.getProduct());
    }

    public ProductDto updateProductById(Integer id, ProductRequestDto productDto) {
        UpdateProductByIdResponse updateProductByIdResponse = (UpdateProductByIdResponse) getWebServiceTemplate().marshalSendAndReceive(mapper.map(id, productDto));
        return mapper.map(updateProductByIdResponse.getProduct());
    }

    public void deleteProductById(Integer id) {
        DeleteProductByIdRequest deleteProductByIdRequest = new DeleteProductByIdRequest();
        deleteProductByIdRequest.setId(id);
        getWebServiceTemplate().marshalSendAndReceive(deleteProductByIdRequest);
    }

    public AmountResponseDto countProductsWherePriceHigher(Long price) {
        CountProductsWherePriceHigherRequest countProductsWherePriceHigherRequest = new CountProductsWherePriceHigherRequest();
        countProductsWherePriceHigherRequest.setPrice(price);
        CountProductsWherePriceHigherResponse countProductsWherePriceHigherResponse = (CountProductsWherePriceHigherResponse) getWebServiceTemplate().marshalSendAndReceive(countProductsWherePriceHigherRequest);
        return new AmountResponseDto(countProductsWherePriceHigherResponse.getAmount());
    }

    public List<ProductDto> getArrayProductsWhereNameIncludeSubstring(String subString) {
        GetArrayProductsWhereNameIncludeSubstringRequest getArrayProductsWhereNameIncludeSubstringRequest = new GetArrayProductsWhereNameIncludeSubstringRequest();
        getArrayProductsWhereNameIncludeSubstringRequest.setSubString(subString);
        GetArrayProductsWhereNameIncludeSubstringResponse getArrayProductsWhereNameIncludeSubstringResponse = (GetArrayProductsWhereNameIncludeSubstringResponse) getWebServiceTemplate().marshalSendAndReceive(getArrayProductsWhereNameIncludeSubstringRequest);
        return getArrayProductsWhereNameIncludeSubstringResponse.getProducts().stream().map(mapper::map).collect(Collectors.toList());
    }

    public List<String> getArrayProductsWhereNameUnique() {
        GetArrayProductsWhereNameUnique getArrayProductsWhereNameUniqueRequest = new GetArrayProductsWhereNameUnique();
        GetArrayProductsWhereNameUnique getArrayProductsWhereNameUniqueResponse = (GetArrayProductsWhereNameUnique) getWebServiceTemplate().marshalSendAndReceive(getArrayProductsWhereNameUniqueRequest);
        return getArrayProductsWhereNameUniqueResponse.getUniqueName();
    }
}