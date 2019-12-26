package com.mongodb.example.mongodbcrud.service;

import com.mongodb.example.mongodbcrud.model.Person;
import com.mongodb.example.mongodbcrud.repository.PersonRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(int id) throws ChangeSetPersister.NotFoundException {
        return personRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Person createPerson(Person personIn) {
        return personRepository.save(personIn);
    }

    public void deletePersonById(int id) {
        personRepository.deleteById(id);
    }
}
