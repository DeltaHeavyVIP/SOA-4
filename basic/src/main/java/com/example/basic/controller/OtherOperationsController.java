package com.example.basic.controller;

import com.example.basic.service.impl.OtherOperationsServiceImpl;
import localhost._8080.entity.CountProductsWherePriceHigherRequest;
import localhost._8080.entity.CountProductsWherePriceHigherResponse;
import localhost._8080.entity.GetArrayProductsWhereNameIncludeSubstringRequest;
import localhost._8080.entity.GetArrayProductsWhereNameIncludeSubstringResponse;
import localhost._8080.entity.GetArrayProductsWhereNameUnique;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@RequiredArgsConstructor
@Endpoint
public class OtherOperationsController {
    private static final String NAMESPACE_URI = "http://localhost:8080/Entity";

    @Autowired
    private OtherOperationsServiceImpl otherOperationsService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "countProductsWherePriceHigherRequest")
    @ResponsePayload
    public CountProductsWherePriceHigherResponse countProductsWherePriceHigher(@RequestPayload CountProductsWherePriceHigherRequest countProductsWherePriceHigherRequest) {
        return otherOperationsService.countProductsWherePriceHigher(countProductsWherePriceHigherRequest.getPrice());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getArrayProductsWhereNameIncludeSubstringRequest")
    @ResponsePayload
    public GetArrayProductsWhereNameIncludeSubstringResponse getArrayProductsWhereNameIncludeSubstring(@RequestPayload GetArrayProductsWhereNameIncludeSubstringRequest getArrayProductsWhereNameIncludeSubstringRequest) {
        return otherOperationsService.getArrayProductsWhereNameIncludeSubstring(getArrayProductsWhereNameIncludeSubstringRequest.getSubString());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getArrayProductsWhereNameUnique")
    @ResponsePayload
    public GetArrayProductsWhereNameUnique getArrayProductsWhereNameUnique() {
        return otherOperationsService.getArrayProductsWhereNameUnique();
    }

}
