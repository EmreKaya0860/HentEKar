package com.hentekar.mapper;

import com.hentekar.model.dto.CarDto;
import com.hentekar.model.entity.Car;

public class CarMapper {

    public static CarDto mapToCarDto(Car car) {
        return new CarDto(
          car.getId(),
          car.getName(),
          car.getType(),
          car.getProductionDate(),
          car.getColor(),
          car.getBrand(),
          car.getModel(),
          car.getPlateNumber(),
          car.getRented()
        );
    }

    public static Car mapToCar(CarDto carDto) {
        return new Car(
                carDto.getId(),
                carDto.getName(),
                carDto.getType(),
                carDto.getProductionDate(),
                carDto.getColor(),
                carDto.getBrand(),
                carDto.getModel(),
                carDto.getPlateNumber(),
                carDto.getRented()

        );
    }
}
