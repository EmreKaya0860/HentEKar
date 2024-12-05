package com.hentekar.service;

import com.hentekar.model.dto.CarDto;
import com.hentekar.model.dto.CarTypeCounterDto;

import java.util.List;

public interface CarService {
    CarDto addCar(CarDto carDto);

    CarDto getCarById(long carId);

    List<CarDto> getAllCars();

    CarDto updateCar(long carId,CarDto updatedCarDto);

    void deleteCar(long carId);

    List<CarDto> findUnrentedCars();

    List<CarTypeCounterDto> getCarTypesCounter();

}
