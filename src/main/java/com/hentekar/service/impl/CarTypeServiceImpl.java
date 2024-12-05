package com.hentekar.service.impl;

import com.hentekar.model.dto.CarTypeCounterDto;
import com.hentekar.model.entity.Car;
import com.hentekar.model.entity.CarType;
import com.hentekar.repository.CarRepository;
import com.hentekar.service.CarTypeService;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarTypeServiceImpl implements CarTypeService {

    private CarRepository carRepository;

//    @Override
//    public List<CarType> getCarTypesCounter() {
//        List<Car> cars = carRepository.findAll();
//
//        Map<String, Long> carTypeCountMap = cars.stream()
//                .collect(Collectors.groupingBy(car -> car.getType(), Collectors.counting()));
//
//        return carTypeCountMap.entrySet().stream()
//                .map(entry -> new CarType(,entry.getKey(), entry.getValue()))
//                .collect(Collectors.toList());
//    }
}
