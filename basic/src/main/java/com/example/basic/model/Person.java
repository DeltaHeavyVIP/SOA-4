package com.example.basic.model;

import localhost._8080.entity.ColorDto;
import localhost._8080.entity.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @Size(max = 40)
    @Column(name = "passport", nullable = false)
    private String passportID; //Длина строки не должна быть больше 40, Поле не может быть null

    @NotBlank
    @Column(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой

    @NotNull
    @Column(name = "eyeColor")
    @Enumerated(EnumType.STRING)
    private Color eyeColor; //Поле не может быть null

    @NotNull
    @Column(name = "hairColor")
    @Enumerated(EnumType.STRING)
    private Color hairColor; //Поле может быть null

    @NotNull
    @Column(name = "nationality")
    @Enumerated(EnumType.STRING)
    private Country nationality; //Поле может быть null

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    private Location location; //Поле может быть null

    public ColorDto getEyeColorDtoFromPerson() {
        return ColorDto.valueOf(this.getEyeColor().toString());
    }

    public ColorDto getHairColorDtoFromPerson() {
        return ColorDto.valueOf(this.getHairColor().toString());
    }

    public CountryDto getNationalityDtoFromPerson() {
        return CountryDto.valueOf(this.getNationality().toString());
    }

    public com.example.objects.common.ColorDto getEyeColorDtoFromPersonRest() {
        return com.example.objects.common.ColorDto.valueOf(this.getEyeColor().toString());
    }

    public com.example.objects.common.ColorDto getHairColorDtoFromPersonRest() {
        return com.example.objects.common.ColorDto.valueOf(this.getHairColor().toString());
    }

    public com.example.objects.common.CountryDto getNationalityDtoFromPersonRest() {
        return com.example.objects.common.CountryDto.valueOf(this.getNationality().toString());
    }
}
