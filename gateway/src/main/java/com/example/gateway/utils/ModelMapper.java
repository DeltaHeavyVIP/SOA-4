package com.example.gateway.utils;

import com.example.objects.basic.request.ProductRequestDto;
import com.example.objects.common.ColorDto;
import com.example.objects.common.CoordinatesDto;
import com.example.objects.common.CountryDto;
import com.example.objects.common.FilterDto;
import com.example.objects.common.LocationDto;
import com.example.objects.common.PersonDto;
import com.example.objects.common.ProductDto;
import com.example.objects.common.UnitOfMeasureDto;
import entity.CreateProductRequest;
import entity.GetProductsByFilterRequest;
import entity.UpdateProductByIdRequest;
import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class ModelMapper {

    public ProductDto map(entity.ProductDto xml) {
        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setX(xml.getCoordinates().getX());
        coordinatesDto.setY(xml.getCoordinates().getY());

        LocationDto locationDto = new LocationDto();
        locationDto.setX(xml.getOwner().getLocation().getX());
        locationDto.setY(xml.getOwner().getLocation().getY());
        locationDto.setZ(xml.getOwner().getLocation().getZ());

        PersonDto personDto = new PersonDto();
        personDto.setPassportID(xml.getOwner().getPassportID());
        personDto.setName(xml.getOwner().getName());
        personDto.setEyeColor(getColorDtoFromXMLColorDto(xml.getOwner().getEyeColor()));
        personDto.setHairColor(getColorDtoFromXMLColorDto(xml.getOwner().getHairColor()));
        personDto.setLocation(locationDto);
        personDto.setNationality(getCountryDtoFromXMLCountryDto(xml.getOwner().getNationality()));

        ProductDto productDto = new ProductDto();
        productDto.setId(xml.getId());
        productDto.setName(xml.getName());
        productDto.setCoordinates(coordinatesDto);
        productDto.setCreationDate(xMLGregorianCalendarToZonedDateTime(xml.getCreationDate()));
        productDto.setPrice(xml.getPrice());
        productDto.setPartNumber(xml.getPartNumber());
        productDto.setManufactureCost(xml.getManufactureCost());
        productDto.setUnitOfMeasure(getUnitOfMeasureDtoFromXMLUnitOfMeasureDto(xml.getUnitOfMeasure()));
        productDto.setOwner(personDto);

        return productDto;
    }

    public GetProductsByFilterRequest map(FilterDto filterDto) {
        GetProductsByFilterRequest getProductsByFilterRequest = new GetProductsByFilterRequest();
        getProductsByFilterRequest.setPage(filterDto.getPage());
        getProductsByFilterRequest.setPageSize(filterDto.getPageSize());

        if (filterDto.getId() != null) {
            getProductsByFilterRequest.setId(filterDto.getId());
        }
        if (filterDto.getName() != null && !filterDto.getName().isEmpty()) {
            getProductsByFilterRequest.setName(filterDto.getName());
        }
        if (filterDto.getCoordinateX() != null) {
            getProductsByFilterRequest.setCoordinateX(filterDto.getCoordinateX());
        }
        if (filterDto.getCoordinateY() != null) {
            getProductsByFilterRequest.setCoordinateY(filterDto.getCoordinateY());
        }
        if (filterDto.getPrice() != null) {
            getProductsByFilterRequest.setPrice(filterDto.getPrice());
        }
        if (filterDto.getPartNumber() != null && !filterDto.getPartNumber().isEmpty()) {
            getProductsByFilterRequest.setPartNumber(filterDto.getPartNumber());
        }
        if (filterDto.getManufactureCost() != null) {
            getProductsByFilterRequest.setManufactureCost(filterDto.getManufactureCost());
        }
        if (filterDto.getUnitOfMeasure() != null && !filterDto.getUnitOfMeasure().isEmpty() && !filterDto.getUnitOfMeasure().equals("-")) {
            getProductsByFilterRequest.setUnitOfMeasure(getXMLUnitOfMeasureDtoFromUnitOfMeasureDto(filterDto.getUnitOfMeasure()));
        }
        if (filterDto.getOwnerName() != null && !filterDto.getOwnerName().isEmpty()) {
            getProductsByFilterRequest.setOwnerName(filterDto.getOwnerName());
        }
        if (filterDto.getOwnerPassportId() != null && !filterDto.getOwnerPassportId().isEmpty()) {
            getProductsByFilterRequest.setOwnerPassportId(filterDto.getOwnerPassportId());
        }
        if (filterDto.getOwnerEyeColor() != null && !filterDto.getOwnerEyeColor().isEmpty() && !filterDto.getOwnerEyeColor().equals("-")) {
            getProductsByFilterRequest.setOwnerEyeColor(getXMLColorDtoFromColorDto(filterDto.getOwnerEyeColor()));
        }
        if (filterDto.getOwnerHairColor() != null && !filterDto.getOwnerHairColor().isEmpty() && !filterDto.getOwnerHairColor().equals("-")) {
            getProductsByFilterRequest.setOwnerHairColor(getXMLColorDtoFromColorDto(filterDto.getOwnerHairColor()));
        }
        if (filterDto.getOwnerNationality() != null && !filterDto.getOwnerNationality().isEmpty() && !filterDto.getOwnerNationality().equals("-")) {
            getProductsByFilterRequest.setOwnerNationality(getXMLCountryDtoFromCountryDto(filterDto.getOwnerNationality()));
        }
        if (filterDto.getOwnerLocationX() != null) {
            getProductsByFilterRequest.setOwnerLocationX(filterDto.getOwnerLocationX());
        }
        if (filterDto.getOwnerLocationY() != null) {
            getProductsByFilterRequest.setOwnerLocationY(filterDto.getOwnerLocationY());
        }
        if (filterDto.getOwnerLocationZ() != null) {
            getProductsByFilterRequest.setOwnerLocationZ(filterDto.getOwnerLocationZ());
        }

        GetProductsByFilterRequest.OrderBy orderBy = new GetProductsByFilterRequest.OrderBy();
        for (String entityKey : filterDto.getOrderBy().keySet()) {
            orderBy.setField(entityKey);
            orderBy.setSortType(filterDto.getOrderBy().get(entityKey));
            getProductsByFilterRequest.getOrderBy().add(orderBy);
        }

        return getProductsByFilterRequest;
    }

    public CreateProductRequest map(ProductRequestDto productRequestDto) {
        entity.CoordinatesDto coordinatesDto = new entity.CoordinatesDto();
        coordinatesDto.setX(productRequestDto.getCoordinates().getX());
        coordinatesDto.setY(productRequestDto.getCoordinates().getY());

        entity.LocationDto locationDto = new entity.LocationDto();
        locationDto.setX(productRequestDto.getOwner().getLocation().getX());
        locationDto.setY(productRequestDto.getOwner().getLocation().getY());
        locationDto.setZ(productRequestDto.getOwner().getLocation().getZ());

        entity.PersonDto personDto = new entity.PersonDto();
        personDto.setPassportID(productRequestDto.getOwner().getPassportID());
        personDto.setName(productRequestDto.getOwner().getName());
        personDto.setEyeColor(getXMLColorDtoFromColorDto(productRequestDto.getOwner().getEyeColor().toString()));
        personDto.setHairColor(getXMLColorDtoFromColorDto(productRequestDto.getOwner().getHairColor().toString()));
        personDto.setLocation(locationDto);
        personDto.setNationality(getXMLCountryDtoFromCountryDto(productRequestDto.getOwner().getNationality().toString()));

        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setName(productRequestDto.getName());
        createProductRequest.setCoordinates(coordinatesDto);
        createProductRequest.setPrice(productRequestDto.getPrice());
        createProductRequest.setPartNumber(productRequestDto.getPartNumber());
        createProductRequest.setManufactureCost(productRequestDto.getManufactureCost());
        createProductRequest.setUnitOfMeasure(getXMLUnitOfMeasureDtoFromUnitOfMeasureDto(productRequestDto.getUnitOfMeasure().toString()));
        createProductRequest.setOwner(personDto);

        return createProductRequest;
    }

    public UpdateProductByIdRequest map(Integer id, ProductRequestDto productRequestDto) {
        entity.CoordinatesDto coordinatesDto = new entity.CoordinatesDto();
        coordinatesDto.setX(productRequestDto.getCoordinates().getX());
        coordinatesDto.setY(productRequestDto.getCoordinates().getY());

        entity.LocationDto locationDto = new entity.LocationDto();
        locationDto.setX(productRequestDto.getOwner().getLocation().getX());
        locationDto.setY(productRequestDto.getOwner().getLocation().getY());
        locationDto.setZ(productRequestDto.getOwner().getLocation().getZ());

        entity.PersonDto personDto = new entity.PersonDto();
        personDto.setPassportID(productRequestDto.getOwner().getPassportID());
        personDto.setName(productRequestDto.getOwner().getName());
        personDto.setEyeColor(getXMLColorDtoFromColorDto(productRequestDto.getOwner().getEyeColor().toString()));
        personDto.setHairColor(getXMLColorDtoFromColorDto(productRequestDto.getOwner().getHairColor().toString()));
        personDto.setLocation(locationDto);
        personDto.setNationality(getXMLCountryDtoFromCountryDto(productRequestDto.getOwner().getNationality().toString()));

        UpdateProductByIdRequest updateProductByIdRequest = new UpdateProductByIdRequest();
        updateProductByIdRequest.setId(id);
        updateProductByIdRequest.setName(productRequestDto.getName());
        updateProductByIdRequest.setCoordinates(coordinatesDto);
        updateProductByIdRequest.setPrice(productRequestDto.getPrice());
        updateProductByIdRequest.setPartNumber(productRequestDto.getPartNumber());
        updateProductByIdRequest.setManufactureCost(productRequestDto.getManufactureCost());
        updateProductByIdRequest.setUnitOfMeasure(getXMLUnitOfMeasureDtoFromUnitOfMeasureDto(productRequestDto.getUnitOfMeasure().toString()));
        updateProductByIdRequest.setOwner(personDto);

        return updateProductByIdRequest;
    }

    private CountryDto getCountryDtoFromXMLCountryDto(entity.CountryDto countryDto) {
        return CountryDto.valueOf(countryDto.toString());
    }

    private ColorDto getColorDtoFromXMLColorDto(entity.ColorDto colorDto) {
        return ColorDto.valueOf(colorDto.toString());
    }

    private UnitOfMeasureDto getUnitOfMeasureDtoFromXMLUnitOfMeasureDto(entity.UnitOfMeasureDto unitOfMeasureDto) {
        return UnitOfMeasureDto.valueOf(unitOfMeasureDto.toString());
    }

    private entity.CountryDto getXMLCountryDtoFromCountryDto(String countryDto) {
        return entity.CountryDto.valueOf(countryDto);
    }

    private entity.ColorDto getXMLColorDtoFromColorDto(String colorDto) {
        return entity.ColorDto.valueOf(colorDto);
    }

    private entity.UnitOfMeasureDto getXMLUnitOfMeasureDtoFromUnitOfMeasureDto(String unitOfMeasureDto) {
        return entity.UnitOfMeasureDto.valueOf(unitOfMeasureDto);
    }

    private ZonedDateTime xMLGregorianCalendarToZonedDateTime(
            XMLGregorianCalendar calendar) {
        if (calendar != null) {
            ZonedDateTime zonedDateTime = calendar.toGregorianCalendar()
                    .toZonedDateTime();
            return ZonedDateTime.of(ZonedDateTime.ofInstant(zonedDateTime.toInstant(),
                    ZoneId.systemDefault()).toLocalDateTime(), ZoneId.systemDefault());
        }
        return null;
    }
}
