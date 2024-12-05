package com.hentekar.service.impl;

import com.hentekar.model.dto.CarDto;
import com.hentekar.model.dto.CarTypeCounterDto;
import com.hentekar.model.entity.Car;
import com.hentekar.configuration.ResourceNotFoundException;
import com.hentekar.mapper.CarMapper;
import com.hentekar.repository.CarRepository;
import com.hentekar.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Override
    public CarDto addCar(CarDto carDto) {

        Car car = CarMapper.mapToCar(carDto);
        Car savedCar = carRepository.save(car);

        return CarMapper.mapToCarDto(savedCar);
    }

    @Override
    public CarDto getCarById(long carId) {
//        Car carT = carRepository.findById(carId).orElse(null);
//        if (carT == null) {
//            throw new ResourceNotFoundException("Car not found");
//        }

        Car car = carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException("Car not found with given id: " + carId));


        return CarMapper.mapToCarDto(car);
    }

    @Override
    public List<CarDto> getAllCars() {

        List<Car> cars = carRepository.findAll();

        return cars.stream().map((car) -> CarMapper.mapToCarDto(car)).collect(Collectors.toList());
    }

    @Override
    public CarDto updateCar(long carId, CarDto updatedCarDto) {

        Car car = carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException("Car not found with given id: " + carId));


        car.setName(updatedCarDto.getName());
        car.setType(updatedCarDto.getType());
        car.setProductionDate(updatedCarDto.getProductionDate());
        car.setColor(updatedCarDto.getColor());
        car.setBrand(updatedCarDto.getBrand());
        car.setModel(updatedCarDto.getModel());
        car.setPlateNumber(updatedCarDto.getPlateNumber());
        car.setRented(updatedCarDto.getRented());

        Car savedCar = carRepository.save(car);

        return CarMapper.mapToCarDto(savedCar);
    }

    @Override
    public void deleteCar(long carId) {

        Car car = carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException("Car not found with given id: " + carId));

        carRepository.delete(car);
    }

    @Override
    public List<CarDto> findUnrentedCars() {

        List<Car> unrentedCars = carRepository.findByRentedEquals(false);

        return unrentedCars.stream().map((car) -> CarMapper.mapToCarDto(car)).collect(Collectors.toList());
    }

    @Override
    public List<CarTypeCounterDto> getCarTypesCounter() {

        List<Car> cars = carRepository.findAll();

        Map<String, Long> carTypeCountMap = cars.stream()
                .collect(Collectors.groupingBy(car -> car.getType(), Collectors.counting()));

        return carTypeCountMap.entrySet().stream()
                .map(entry -> new CarTypeCounterDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
