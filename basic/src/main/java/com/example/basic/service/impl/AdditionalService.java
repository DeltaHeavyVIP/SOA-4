package com.example.basic.service.impl;

import com.example.basic.exception.InvalidInputDataException;
import com.example.basic.model.Color;
import com.example.basic.model.Coordinates;
import com.example.basic.model.Country;
import com.example.basic.model.Location;
import com.example.basic.model.Person;
import com.example.basic.model.Product;
import com.example.basic.model.UnitOfMeasure;
import com.example.basic.repositories.CoordinatesRepo;
import com.example.basic.repositories.LocationRepo;
import com.example.basic.repositories.PersonRepo;
import com.example.basic.repositories.ProductRepo;
import com.example.objects.basic.request.ProductRequestDto;
import com.example.objects.common.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdditionalService {

    private ProductRepo productRepo;
    private PersonRepo personRepo;
    private CoordinatesRepo coordinatesRepo;
    private LocationRepo locationRepo;
    private ConversionService conversionService;

    @Autowired
    public AdditionalService(PersonRepo personRepo, ProductRepo productRepo, CoordinatesRepo coordinatesRepo, LocationRepo locationRepo, @Qualifier("mvcConversionService") ConversionService conversionService) {
        this.personRepo = personRepo;
        this.productRepo = productRepo;
        this.coordinatesRepo = coordinatesRepo;
        this.locationRepo = locationRepo;
        this.conversionService = conversionService;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        return productList.stream().map(p -> conversionService.convert(p, ProductDto.class)).collect(Collectors.toList());
    }

    public ProductDto updateProductById(Integer id, ProductRequestDto productDto) {
        Product product = productRepo.findById(id).orElseThrow(() -> new InvalidInputDataException(String.format("Product with ID %d not found", id)));
        product.setName(productDto.getName());
        product.setCoordinates(coordinatesRepo.findFirstByXAndY(productDto.getCoordinates().getX(), productDto.getCoordinates().getY()).orElse(conversionService.convert(productDto.getCoordinates(), Coordinates.class)));
        product.setPrice(productDto.getPrice());
        product.setPartNumber(productDto.getPartNumber());
        product.setManufactureCost(productDto.getManufactureCost());
        product.setUnitOfMeasure(conversionService.convert(productDto.getUnitOfMeasure(), UnitOfMeasure.class));
        product.setOwner(personRepo.save(new Person(productDto.getOwner().getPassportID(), productDto.getOwner().getName(), conversionService.convert(productDto.getOwner().getEyeColor(), Color.class), conversionService.convert(productDto.getOwner().getHairColor(), Color.class), conversionService.convert(productDto.getOwner().getNationality(), Country.class), locationRepo.findFirstByXAndYAndZ(productDto.getOwner().getLocation().getX(), productDto.getOwner().getLocation().getY(), productDto.getOwner().getLocation().getZ()).orElse(conversionService.convert(productDto.getOwner().getLocation(), Location.class)))));
        return conversionService.convert(productRepo.save(product), ProductDto.class);
    }
}
