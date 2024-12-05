package com.hentekar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private long id;
    private String name;
    private String type;
    private Date productionDate;
    private String color;
    private String brand;
    private String model;
    private String plateNumber;
    private Boolean rented;
}
