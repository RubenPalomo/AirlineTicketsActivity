package com.airline.AirlineUser.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("users")
public class User {
    @Id
    private String document;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private int age;

    public User() {
    }

    public User(String document, String firstName, String lastName, int age) {
        setDocument(document);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{document:" + document + ", firstName:" + firstName + ", lastName:" + lastName + ", age:" + age
                + "}";
    }
}
