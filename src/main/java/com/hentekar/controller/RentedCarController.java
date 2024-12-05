package com.hentekar.controller;

import com.hentekar.model.dto.RentedCarDto;
import com.hentekar.service.RentedCarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rentedCars")
public class RentedCarController {

    private RentedCarService rentedCarService;

    @PostMapping
    public ResponseEntity<RentedCarDto> addRentedCar(@RequestBody RentedCarDto rentedCarDto) {
        RentedCarDto savedRentedCar = rentedCarService.addRentedCar(rentedCarDto);
        return new ResponseEntity<>(savedRentedCar, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RentedCarDto> getRentedCarById(@PathVariable("id") long rentedCarId) {

        RentedCarDto rentedCarDto = rentedCarService.getRentedCarById(rentedCarId);

        return ResponseEntity.ok(rentedCarDto);
    }

    @GetMapping
    public ResponseEntity<List<RentedCarDto>> getAllRentedCars() {

        List<RentedCarDto> rentedCars = rentedCarService.getAllRentedCars();

        return ResponseEntity.ok(rentedCars);
    }

    @PutMapping("{id}")
    public ResponseEntity<RentedCarDto> updatePerson(@PathVariable("id") long rantedCarId, @RequestBody RentedCarDto rentedCarDto) {

        RentedCarDto updateRentedCar = rentedCarService.updateRentedCar(rantedCarId, rentedCarDto);
        return ResponseEntity.ok(updateRentedCar);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRentedCar(@PathVariable("id") long rentedCarId) {
        rentedCarService.deleteRentedCar(rentedCarId);
        return ResponseEntity.ok("Deleted RentedCar successfully");
    }
}
