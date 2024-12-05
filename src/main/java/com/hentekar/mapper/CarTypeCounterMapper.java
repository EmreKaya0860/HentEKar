package com.hentekar.mapper;

import com.hentekar.model.dto.CarTypeCounterDto;
import com.hentekar.model.entity.Car;

public class CarTypeCounterMapper {

    public static CarTypeCounterDto mapToCarTypesCounterDto(String type, long count){
        return new CarTypeCounterDto(
                type,
                count
        );
    }
}
