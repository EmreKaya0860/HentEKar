package com.hentekar.controller;

import com.hentekar.model.dto.CarDto;
import com.hentekar.model.dto.CarTypeCounterDto;
import com.hentekar.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto) {
    CarDto savedCar = carService.addCar(carDto);
    //return ResponseEntity.ok(savedCar);
    return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CarDto> getCarByID(@PathVariable("id") long carId) {

        CarDto carDto = carService.getCarById(carId);
        return ResponseEntity. ok(carDto);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("unrented")
    public ResponseEntity<List<CarDto>> getUnrentedCars() {

        List<CarDto> unrentedCars = carService.findUnrentedCars();

        return ResponseEntity.ok(unrentedCars);
    }

    @GetMapping("types")
    public ResponseEntity<List<CarTypeCounterDto>> getCarTypes() {

        List<CarTypeCounterDto> carTypes = carService.getCarTypesCounter();

        return ResponseEntity.ok(carTypes);

    }

    @PutMapping("{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable("id") long carId, @RequestBody CarDto carDto) {
        CarDto savedCar = carService.updateCar(carId, carDto);

        return ResponseEntity.ok(savedCar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCar(@PathVariable("id") long carId) {
        carService.deleteCar(carId);
        return ResponseEntity.ok("Car deleted successfully");
    }
}
