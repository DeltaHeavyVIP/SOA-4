package com.example.basic.converter;

import com.example.basic.model.UnitOfMeasure;
import localhost._8080.entity.UnitOfMeasureDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureDtoToUnitOfMeasure implements Converter<UnitOfMeasureDto, UnitOfMeasure> {

    @Override
    public UnitOfMeasure convert(UnitOfMeasureDto unitOfMeasureDto) {
        return UnitOfMeasure.valueOf(unitOfMeasureDto.toString());
    }

}