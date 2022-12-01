package com.airline.AirlineUser.models;

import org.json.JSONObject;
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
    @Field
    private String password;
    @Field
    private String nationality;

    public User() {
    }

    public User(String document, String firstName, String lastName, int age, String password, String nationality) {
        setDocument(document);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setPassword(password);
        setNationality(nationality);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        JSONObject item = new JSONObject();

        item.put("document", getDocument());
        item.put("firstName", getFirstName());
        item.put("lastName", getLastName());
        item.put("age", getAge());
        item.put("password", getPassword());
        item.put("nationality", getNationality());

        System.out.println(item.toString());

        return item.toString();
        // return "User [ document=" + document + ", firstName=" + firstName + ",
        // lastName=" + lastName + ", age="
        // + age
        // + ", password=" + password + ", nationality=" + nationality + "]";
    }
}
