package com.example.basic.converter;

import com.example.basic.model.Product;
import localhost._8080.entity.CoordinatesDto;
import localhost._8080.entity.LocationDto;
import localhost._8080.entity.PersonDto;
import localhost._8080.entity.ProductDto;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeFactory;
import java.util.GregorianCalendar;

@Component
public class ProductToProductResponseDto implements Converter<Product, ProductDto> {
    @SneakyThrows
    @Override
    public ProductDto convert(Product product) {
        CoordinatesDto coordinatesRequestDto = new CoordinatesDto();
        coordinatesRequestDto.setX(product.getCoordinates().getX());
        coordinatesRequestDto.setY(product.getCoordinates().getY());

        LocationDto locationRequestDto = new LocationDto();
        locationRequestDto.setX(product.getOwner().getLocation().getX());
        locationRequestDto.setY(product.getOwner().getLocation().getY());
        locationRequestDto.setZ(product.getOwner().getLocation().getZ());

        PersonDto personRequestDto = new PersonDto();
        personRequestDto.setName(product.getOwner().getName());
        personRequestDto.setPassportID(product.getOwner().getPassportID());
        personRequestDto.setEyeColor(product.getOwner().getEyeColorDtoFromPerson());
        personRequestDto.setHairColor(product.getOwner().getHairColorDtoFromPerson());
        personRequestDto.setNationality(product.getOwner().getNationalityDtoFromPerson());
        personRequestDto.setLocation(locationRequestDto);

        ProductDto productResponseDto = new ProductDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setCoordinates(coordinatesRequestDto);
        productResponseDto.setCreationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(GregorianCalendar.from(product.getCreationDate())));
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setPartNumber(product.getPartNumber());
        productResponseDto.setManufactureCost(product.getManufactureCost());
        productResponseDto.setUnitOfMeasure(product.getUnitOfMeasureDtoFromProduct());
        productResponseDto.setOwner(personRequestDto);
        return productResponseDto;
    }
}
