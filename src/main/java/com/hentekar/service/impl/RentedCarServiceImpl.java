package com.hentekar.service.impl;

import com.hentekar.model.dto.RentedCarDto;
import com.hentekar.model.entity.RentedCar;
import com.hentekar.configuration.ResourceNotFoundException;
import com.hentekar.mapper.RentedCarMapper;
import com.hentekar.repository.RentedCarRepository;
import com.hentekar.service.RentedCarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentedCarServiceImpl implements RentedCarService {

    private RentedCarRepository rentedCarRepository;

    @Override
    public RentedCarDto addRentedCar(RentedCarDto rentedCarDto) {

        RentedCar rentedCar = RentedCarMapper.mapToRentedCar(rentedCarDto);
        RentedCar savedRentedCar = rentedCarRepository.save(rentedCar);

        return RentedCarMapper.mapToRentedCarDto(savedRentedCar);
    }

    @Override
    public RentedCarDto getRentedCarById(long rentedCarId) {

        RentedCar rentedCar = rentedCarRepository.findById(rentedCarId)
                .orElseThrow(() -> new ResourceNotFoundException("Rented Car Not Found by given Id: " + rentedCarId));

        return RentedCarMapper.mapToRentedCarDto(rentedCar);
    }

    @Override
    public List<RentedCarDto> getAllRentedCars() {

        List<RentedCar> rentedCars = rentedCarRepository.findAll();

        return rentedCars.stream().map((rentedCar) -> RentedCarMapper.mapToRentedCarDto(rentedCar))
                .collect(Collectors.toList());
    }

    @Override
    public RentedCarDto updateRentedCar(long rentedCarId, RentedCarDto rentedCarDto) {

        RentedCar rentedCar = rentedCarRepository.findById(rentedCarId)
                .orElseThrow(() -> new ResourceNotFoundException("Rented Car Not Found by given Id: " + rentedCarId));

        rentedCar.setCarId(rentedCarDto.getCarId());
        rentedCar.setPersonId(rentedCarDto.getPersonId());

        RentedCar savedRentedCar = rentedCarRepository.save(rentedCar);

        return RentedCarMapper.mapToRentedCarDto(savedRentedCar);
    }

    @Override
    public void deleteRentedCar(long rentedCarId) {

        RentedCar rentedCar = rentedCarRepository.findById(rentedCarId)
                .orElseThrow(() -> new ResourceNotFoundException("Rented Car Not Found by given Id: " + rentedCarId));

        rentedCarRepository.delete(rentedCar);

    }
}
