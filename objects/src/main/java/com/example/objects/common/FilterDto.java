package com.example.objects.common;

import lombok.Data;

import java.util.Map;

@Data
public class FilterDto {
    private int page;
    private int pageSize;
    private Integer id;
    private String name;
    private Float coordinateX;
    private Float coordinateY;
    private Long price;
    private String partNumber;
    private Integer manufactureCost;
    private String unitOfMeasure;
    private String ownerName;
    private String ownerPassportId;
    private String ownerEyeColor;
    private String ownerHairColor;
    private String ownerNationality;
    private Integer ownerLocationX;
    private Double ownerLocationY;
    private Double ownerLocationZ;
    private Map<String, String> orderBy;
}
