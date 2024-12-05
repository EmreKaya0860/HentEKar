package com.hentekar.service;

import com.hentekar.model.dto.RentedCarDto;

import java.util.List;


public interface RentedCarService {

    RentedCarDto addRentedCar(RentedCarDto rentedCarDto);

    RentedCarDto getRentedCarById(long rentedCarId);

    List<RentedCarDto> getAllRentedCars();

    RentedCarDto updateRentedCar(long rentedCarId,RentedCarDto rentedCarDto);

    void deleteRentedCar(long rentedCarId);
}
