package com.hentekar.repository;

import com.hentekar.model.entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType, Long> {
}
