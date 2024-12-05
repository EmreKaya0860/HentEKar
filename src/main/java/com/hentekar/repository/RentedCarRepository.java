package com.hentekar.repository;

import com.hentekar.model.entity.RentedCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentedCarRepository extends JpaRepository<RentedCar, Long> {
}
