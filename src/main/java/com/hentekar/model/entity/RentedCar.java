package com.hentekar.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rentedCars")
public class RentedCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int carId;
    private int personId;
}
