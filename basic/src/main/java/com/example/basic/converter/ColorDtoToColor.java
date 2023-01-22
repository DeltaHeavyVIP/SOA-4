package com.example.basic.converter;

import com.example.basic.model.Color;
import localhost._8080.entity.ColorDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ColorDtoToColor implements Converter<ColorDto, Color> {

    @Override
    public Color convert(ColorDto colorDto) {
        return Color.valueOf(colorDto.toString());
    }

}
