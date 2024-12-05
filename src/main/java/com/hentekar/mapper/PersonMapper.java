package com.hentekar.mapper;

import com.hentekar.model.dto.PersonDto;
import com.hentekar.model.entity.Person;

public class PersonMapper {

    public static PersonDto mapToPersonDto(Person person) {
        return new PersonDto(
          person.getId(),
          person.getName(),
          person.getDateOfBirth(),
          person.getGender()
        );
    }

    public static Person mapToPerson(PersonDto personDto) {
        return new Person(
          personDto.getId(),
          personDto.getName(),
          personDto.getDateOfBirth(),
          personDto.getGender()
        );
    }
}
