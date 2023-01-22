package com.example.basic.service;

import localhost._8080.entity.CountProductsWherePriceHigherResponse;
import localhost._8080.entity.GetArrayProductsWhereNameIncludeSubstringResponse;
import localhost._8080.entity.GetArrayProductsWhereNameUnique;

public interface OtherOperationsService {
    CountProductsWherePriceHigherResponse countProductsWherePriceHigher(Long price);

    GetArrayProductsWhereNameIncludeSubstringResponse getArrayProductsWhereNameIncludeSubstring(String subString);

    GetArrayProductsWhereNameUnique getArrayProductsWhereNameUnique();
}
