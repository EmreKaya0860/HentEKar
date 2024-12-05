package com.hentekar.service.impl;

import com.hentekar.model.dto.PersonDto;
import com.hentekar.model.entity.Person;
import com.hentekar.configuration.ResourceNotFoundException;
import com.hentekar.mapper.PersonMapper;
import com.hentekar.repository.PersonRepository;
import com.hentekar.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public PersonDto addPerson(PersonDto personDto) {

        Person person = PersonMapper.mapToPerson(personDto);
        Person savedPerson = personRepository.save(person);

        return PersonMapper.mapToPersonDto(savedPerson);
    }

    @Override
    public PersonDto getPersonById(long personId) {

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found by given id: " + personId));

        return PersonMapper.mapToPersonDto(person);
    }

    @Override
    public List<PersonDto> getAllPersons() {

        List<Person> persons = personRepository.findAll();

        return persons.stream().map((person) -> PersonMapper.mapToPersonDto(person))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto updatePerson(long personId, PersonDto personDto) {

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found by given id: " + personId));

        person.setName(personDto.getName());
        person.setDateOfBirth(personDto.getDateOfBirth());
        person.setGender(personDto.getGender());

        Person savedPerson = personRepository.save(person);

        return PersonMapper.mapToPersonDto(savedPerson);
    }

    @Override
    public void deletePerson(long personId) {

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found by given id: " + personId));

        personRepository.delete(person);
    }

}
