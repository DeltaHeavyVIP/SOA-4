package com.example.basic.converter;

import localhost._8080.entity.GetProductsByFilterRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GetProductsByFilterRequestOrderByListToMap implements Converter<List<GetProductsByFilterRequest.OrderBy>, Map> {

    @Override
    public Map<String, String> convert(List<GetProductsByFilterRequest.OrderBy> list) {
        Map<String, String> namePropertyMap = new HashMap<>();
        for (GetProductsByFilterRequest.OrderBy orderby : list) {
            namePropertyMap.put(orderby.getField(), orderby.getSortType());
        }
        return namePropertyMap;
    }
}
