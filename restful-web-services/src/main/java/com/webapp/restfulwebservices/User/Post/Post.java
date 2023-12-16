package com.webapp.restfulwebservices.User.Post;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webapp.restfulwebservices.User.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;


    @Size(min = 2, message = "name should be more than 2 character")
    private String description;


    public Post() {
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
