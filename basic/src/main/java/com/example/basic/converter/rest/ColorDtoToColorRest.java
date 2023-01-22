package com.example.basic.converter.rest;

import com.example.basic.model.Color;
import com.example.objects.common.ColorDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ColorDtoToColorRest implements Converter<ColorDto, Color> {

    @Override
    public Color convert(ColorDto colorDto) {
        return Color.valueOf(colorDto.toString());
    }

}
