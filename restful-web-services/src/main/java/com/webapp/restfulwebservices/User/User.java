package com.webapp.restfulwebservices.User;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {





    private int id;

    @Size(min = 2, message = "name should be more than 2 character")
    private String name;
    private LocalDate birthDate;


    public User(int id, String name, LocalDate birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }


    public int getId() {
        return id;
    }

//    getter setter to string


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
    }
}