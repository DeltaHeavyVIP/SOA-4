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
import com.example.basic.service.BasicOperationService;
import com.example.basic.utils.Filter;
import localhost._8080.entity.CreateProductRequest;
import localhost._8080.entity.CreateProductResponse;
import localhost._8080.entity.GetAllProducts;
import localhost._8080.entity.GetProductByIdResponse;
import localhost._8080.entity.GetProductsByFilterRequest;
import localhost._8080.entity.GetProductsByFilterResponse;
import localhost._8080.entity.ProductDto;
import localhost._8080.entity.UpdateProductByIdRequest;
import localhost._8080.entity.UpdateProductByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasicOperationServiceImpl implements BasicOperationService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private CoordinatesRepo coordinatesRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    @Qualifier("mvcConversionService")
    private ConversionService conversionService;

    public GetAllProducts getAllProducts() {
        GetAllProducts getAllProducts = new GetAllProducts();

        List<Product> productList = productRepo.findAll();
        List<ProductDto> productResponseDtoList = productList.stream().map(p -> conversionService.convert(p, ProductDto.class)).collect(Collectors.toList());

        getAllProducts.getProducts().addAll(productResponseDtoList);
        return getAllProducts;
    }

    public GetProductByIdResponse getProductById(Integer id) {
        GetProductByIdResponse getProductByIdResponse = new GetProductByIdResponse();
        ProductDto productDto = conversionService.convert(productRepo.findById(id).orElseThrow(() -> new InvalidInputDataException(String.format("Product with ID %d not found", id))), ProductDto.class);
        getProductByIdResponse.setProduct(productDto);
        return getProductByIdResponse;
    }

    public GetProductsByFilterResponse getProductsByFilter(GetProductsByFilterRequest getProductsByFilterRequest) {
        List<Product> productList = productRepo.findAll(Sort.by(Filter.getOrdersByNames(conversionService.convert(getProductsByFilterRequest.getOrderBy(), Map.class)))).stream()
                .filter(p -> {
                    if (getProductsByFilterRequest.getId() != 0) {
                        return getProductsByFilterRequest.getId() == p.getId();
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getCoordinateX() != 0) {
                        return getProductsByFilterRequest.getCoordinateX() == p.getCoordinates().getX();
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getCoordinateY() != 0) {
                        return getProductsByFilterRequest.getCoordinateY() == p.getCoordinates().getY();
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getPrice() != 0) {
                        return getProductsByFilterRequest.getPrice() == p.getPrice();
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getManufactureCost() != 0) {
                        return getProductsByFilterRequest.getManufactureCost() == p.getManufactureCost();
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getOwnerLocationX() != 0) {
                        return getProductsByFilterRequest.getOwnerLocationX() == p.getOwner().getLocation().getX();
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getOwnerLocationY() != 0) {
                        return getProductsByFilterRequest.getOwnerLocationY() == p.getOwner().getLocation().getY();
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getOwnerLocationZ() != 0) {
                        return getProductsByFilterRequest.getOwnerLocationZ() == p.getOwner().getLocation().getZ();
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getName() != null && !getProductsByFilterRequest.getName().isEmpty()) {
                        return getProductsByFilterRequest.getName().equals(p.getName());
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getPartNumber() != null && !getProductsByFilterRequest.getPartNumber().isEmpty()) {
                        return getProductsByFilterRequest.getPartNumber().equals(p.getPartNumber());
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getOwnerName() != null && !getProductsByFilterRequest.getOwnerName().isEmpty()) {
                        return getProductsByFilterRequest.getOwnerName().equals(p.getOwner().getName());
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getOwnerPassportId() != null && !getProductsByFilterRequest.getOwnerPassportId().isEmpty()) {
                        return getProductsByFilterRequest.getOwnerPassportId().equals(p.getOwner().getPassportID());
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getUnitOfMeasure() != null) {
                        return getProductsByFilterRequest.getUnitOfMeasure().toString().equals(p.getUnitOfMeasure().toString());
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getOwnerEyeColor() != null) {
                        return getProductsByFilterRequest.getOwnerEyeColor().toString().equals(p.getOwner().getEyeColor().toString());
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getOwnerHairColor() != null) {
                        return getProductsByFilterRequest.getOwnerHairColor().toString().equals(p.getOwner().getHairColor().toString());
                    }
                    return true;
                })
                .filter(p -> {
                    if (getProductsByFilterRequest.getOwnerNationality() != null) {
                        return getProductsByFilterRequest.getOwnerNationality().toString().equals(p.getOwner().getNationality().toString());
                    }
                    return true;
                })
                .collect(Collectors.toList());
        List<ProductDto> productResponseDtoList = productList.stream().map(p -> conversionService.convert(p, ProductDto.class)).collect(Collectors.toList());

        GetProductsByFilterResponse getProductsByFilterResponse = new GetProductsByFilterResponse();
        Pageable pageable = PageRequest.of(getProductsByFilterRequest.getPage() - 1, getProductsByFilterRequest.getPageSize());
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), productResponseDtoList.size());
        Page<ProductDto> page = null;
        try {
            page = new PageImpl<>(productResponseDtoList.subList(start, end), pageable, productResponseDtoList.size());
        } catch (IllegalArgumentException ex) {
            List<ProductDto> emptyList = new ArrayList<>();
            page = new PageImpl<>(emptyList.subList(0, 0), PageRequest.of(0, 1), emptyList.size());
        }

        getProductsByFilterResponse.getProducts().addAll(page.getContent());
        return getProductsByFilterResponse;
    }

    public CreateProductResponse createProduct(CreateProductRequest createProductRequest) {
        CreateProductResponse createProductResponse = new CreateProductResponse();
        Coordinates coordinates = coordinatesRepo.findFirstByXAndY(createProductRequest.getCoordinates().getX(), createProductRequest.getCoordinates().getY()).orElse(coordinatesRepo.save(conversionService.convert(createProductRequest.getCoordinates(), Coordinates.class)));
        Location location = locationRepo.findFirstByXAndYAndZ(createProductRequest.getOwner().getLocation().getX(), createProductRequest.getOwner().getLocation().getY(), createProductRequest.getOwner().getLocation().getZ()).orElse(locationRepo.save(conversionService.convert(createProductRequest.getOwner().getLocation(), Location.class)));
        Person person = personRepo.findFirstByPassportID(createProductRequest.getOwner().getPassportID()).orElse(personRepo.save(new Person(createProductRequest.getOwner().getPassportID(), createProductRequest.getOwner().getName(), conversionService.convert(createProductRequest.getOwner().getEyeColor(), Color.class), conversionService.convert(createProductRequest.getOwner().getHairColor(), Color.class), conversionService.convert(createProductRequest.getOwner().getNationality(), Country.class), location)));
        Product product = new Product(createProductRequest.getName(), coordinates, createProductRequest.getPrice(), createProductRequest.getPartNumber(), createProductRequest.getManufactureCost(), conversionService.convert(createProductRequest.getUnitOfMeasure(), UnitOfMeasure.class), person);
        createProductResponse.setProduct(conversionService.convert(productRepo.save(product), ProductDto.class));
        return createProductResponse;
    }

    public UpdateProductByIdResponse updateProductById(UpdateProductByIdRequest updateProductByIdRequest) {
        UpdateProductByIdResponse updateProductByIdResponse = new UpdateProductByIdResponse();
        Product product = productRepo.findById(updateProductByIdRequest.getId()).orElseThrow(() -> new InvalidInputDataException(String.format("Product with ID %d not found", updateProductByIdRequest.getId())));
        product.setName(updateProductByIdRequest.getName());
        product.setCoordinates(coordinatesRepo.findFirstByXAndY(updateProductByIdRequest.getCoordinates().getX(), updateProductByIdRequest.getCoordinates().getY()).orElse(conversionService.convert(updateProductByIdRequest.getCoordinates(), Coordinates.class)));
        product.setPrice(updateProductByIdRequest.getPrice());
        product.setPartNumber(updateProductByIdRequest.getPartNumber());
        product.setManufactureCost(updateProductByIdRequest.getManufactureCost());
        product.setUnitOfMeasure(conversionService.convert(updateProductByIdRequest.getUnitOfMeasure(), UnitOfMeasure.class));
        product.setOwner(personRepo.save(new Person(updateProductByIdRequest.getOwner().getPassportID(), updateProductByIdRequest.getOwner().getName(), conversionService.convert(updateProductByIdRequest.getOwner().getEyeColor(), Color.class), conversionService.convert(updateProductByIdRequest.getOwner().getHairColor(), Color.class), conversionService.convert(updateProductByIdRequest.getOwner().getNationality(), Country.class), locationRepo.findFirstByXAndYAndZ(updateProductByIdRequest.getOwner().getLocation().getX(), updateProductByIdRequest.getOwner().getLocation().getY(), updateProductByIdRequest.getOwner().getLocation().getZ()).orElse(conversionService.convert(updateProductByIdRequest.getOwner().getLocation(), Location.class)))));
        updateProductByIdResponse.setProduct(conversionService.convert(productRepo.save(product), ProductDto.class));
        return updateProductByIdResponse;
    }

    public void deleteProductById(Integer id) {
        try {
            productRepo.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new InvalidInputDataException(String.format("Product with ID %d not found", id));
        }
    }

}
