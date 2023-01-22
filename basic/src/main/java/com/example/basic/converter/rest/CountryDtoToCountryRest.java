package com.example.basic.converter.rest;

import com.example.basic.model.Country;
import com.example.objects.common.CountryDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoToCountryRest implements Converter<CountryDto, Country> {
    @Override
    public Country convert(CountryDto countryDto) {
        return Country.valueOf(countryDto.toString());
    }
}