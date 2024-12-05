package com.hentekar.mapper;

import com.hentekar.model.dto.CarTypeDto;
import com.hentekar.model.entity.CarType;

public class CarTypeMapper {

    public static CarTypeDto mapToCarTypeDto(CarType carType, long count) {

        return new CarTypeDto(
                carType.getName(),
                count
        );
    }



}
