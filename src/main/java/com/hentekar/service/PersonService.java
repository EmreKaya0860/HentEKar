package com.hentekar.service;

import com.hentekar.model.dto.PersonDto;

import java.util.List;


public interface PersonService {

    PersonDto addPerson(PersonDto personDto);

    PersonDto getPersonById(long personId);

    List<PersonDto> getAllPersons();

    PersonDto updatePerson(long personId,PersonDto personDto);

    void deletePerson(long personId);

}
