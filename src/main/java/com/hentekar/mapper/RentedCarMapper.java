package com.hentekar.mapper;

import com.hentekar.model.dto.RentedCarDto;
import com.hentekar.model.entity.RentedCar;

public class RentedCarMapper {

    public static RentedCarDto mapToRentedCarDto(RentedCar rentedCar) {
        return new RentedCarDto(
          rentedCar.getId(),
          rentedCar.getCarId(),
          rentedCar.getPersonId()
        );
    }

    public static RentedCar mapToRentedCar(RentedCarDto rentedCarDto) {
        return new RentedCar(
          rentedCarDto.getId(),
          rentedCarDto.getCarId(),
          rentedCarDto.getPersonId()
        );
    }
}
