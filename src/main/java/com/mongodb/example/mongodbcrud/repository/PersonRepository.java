package com.mongodb.example.mongodbcrud.repository;

import com.mongodb.example.mongodbcrud.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, Integer> {
}
