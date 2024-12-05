package com.hentekar.controller;

import com.hentekar.model.dto.PersonDto;
import com.hentekar.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto) {

        PersonDto savedPerson = personService.addPerson(personDto);

        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("id") long personId) {
        PersonDto personDto = personService.getPersonById(personId);
        return ResponseEntity.ok(personDto);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        List<PersonDto> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") long personId, @RequestBody PersonDto personDto) {

        PersonDto updatedPerson = personService.updatePerson(personId, personDto);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") long personId) {
        personService.deletePerson(personId);
        return ResponseEntity.ok("Deleted person successfully.");
    }
}
