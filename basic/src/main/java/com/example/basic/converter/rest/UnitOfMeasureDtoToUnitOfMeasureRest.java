package com.example.basic.converter.rest;

import com.example.basic.model.UnitOfMeasure;
import com.example.objects.common.UnitOfMeasureDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureDtoToUnitOfMeasureRest implements Converter<UnitOfMeasureDto, UnitOfMeasure> {

    @Override
    public UnitOfMeasure convert(UnitOfMeasureDto unitOfMeasureDto) {
        return UnitOfMeasure.valueOf(unitOfMeasureDto.toString());
    }

}