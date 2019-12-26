package com.mongodb.example.mongodbcrud.controller;

import com.mongodb.example.mongodbcrud.model.Person;
import com.mongodb.example.mongodbcrud.service.PersonService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        Person person = personService.getPersonById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody @Valid Person personIn) {
        return ResponseEntity.ok(personService.createPerson(personIn));
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity.HeadersBuilder<?> deletePersonById(@PathVariable int id) {
        personService.deletePersonById(id);
        return ResponseEntity.noContent();
    }
}
