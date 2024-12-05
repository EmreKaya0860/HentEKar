package com.hentekar.repository;

import com.hentekar.model.dto.CarTypeCounterDto;
import com.hentekar.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByRentedEquals(boolean rented);

    //List<Car> findByRented(boolean rented);
}
