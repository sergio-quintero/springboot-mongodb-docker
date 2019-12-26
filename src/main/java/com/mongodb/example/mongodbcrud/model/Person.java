package com.mongodb.example.mongodbcrud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Person")
public class Person {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String gender;

    private int age;
}
