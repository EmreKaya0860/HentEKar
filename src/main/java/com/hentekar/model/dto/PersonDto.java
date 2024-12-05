package com.hentekar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private long id;
    private String name;
    private Date dateOfBirth;
    private String gender;
}
