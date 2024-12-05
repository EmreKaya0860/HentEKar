package com.hentekar.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private Date productionDate;
    private String color;
    private String brand;
    private String model;
    private String plateNumber;

    @Column(columnDefinition = "boolean default false")
    private Boolean rented;

    @PrePersist
    protected void onCreate() {
        if (productionDate == null) {
            productionDate = new Date();
        }
    }
}
