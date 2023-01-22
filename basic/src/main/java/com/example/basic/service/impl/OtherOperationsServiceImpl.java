package com.example.basic.service.impl;

import com.example.basic.exception.InvalidInputDataException;
import com.example.basic.model.Product;
import com.example.basic.repositories.PersonRepo;
import com.example.basic.repositories.ProductRepo;
import com.example.basic.service.OtherOperationsService;
import localhost._8080.entity.CountProductsWherePriceHigherResponse;
import localhost._8080.entity.GetArrayProductsWhereNameIncludeSubstringResponse;
import localhost._8080.entity.GetArrayProductsWhereNameUnique;
import localhost._8080.entity.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OtherOperationsServiceImpl implements OtherOperationsService {

    private ProductRepo productRepo;

    private PersonRepo personRepo;

    private ConversionService conversionService;

    @Autowired
    public OtherOperationsServiceImpl(ProductRepo productRepo, PersonRepo personRepo, ConversionService conversionService) {
        this.productRepo = productRepo;
        this.personRepo = personRepo;
        this.conversionService = conversionService;
    }

    public CountProductsWherePriceHigherResponse countProductsWherePriceHigher(Long price) {
        CountProductsWherePriceHigherResponse countProductsWherePriceHigherResponse = new CountProductsWherePriceHigherResponse();
        if (price == null || price < 1) {
            throw new InvalidInputDataException("Price should be more than 0. Invalid data request");
        }

        countProductsWherePriceHigherResponse.setAmount(productRepo.countAllByPriceAfter(price));
        return countProductsWherePriceHigherResponse;
    }

    public GetArrayProductsWhereNameIncludeSubstringResponse getArrayProductsWhereNameIncludeSubstring(String subString) {
        GetArrayProductsWhereNameIncludeSubstringResponse getArrayProductsWhereNameIncludeSubstringResponse = new GetArrayProductsWhereNameIncludeSubstringResponse();
        if (subString == null || subString.isEmpty()) {
            throw new InvalidInputDataException(String.format("subString should be not null and not empty. Your substring is %s", subString));
        }
        ArrayList<ProductDto> products = new ArrayList<>();
        for (Product product : productRepo.findAllByNameContaining(subString)) {
            products.add(conversionService.convert(product, ProductDto.class));
        }
        getArrayProductsWhereNameIncludeSubstringResponse.getProducts().addAll(products);
        return getArrayProductsWhereNameIncludeSubstringResponse;
    }

    public GetArrayProductsWhereNameUnique getArrayProductsWhereNameUnique() {
        GetArrayProductsWhereNameUnique getArrayProductsWhereNameUnique = new GetArrayProductsWhereNameUnique();
        getArrayProductsWhereNameUnique.getUniqueName().addAll(personRepo.findAllPersonUniqueName());
        return getArrayProductsWhereNameUnique;
    }
}
