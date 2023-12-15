package com.webapp.restfulwebservices.User;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService userDaoService;



    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping( "/users/{user_id}")
    public User retrieveAllUser(@PathVariable int user_id) {

        User user = userDaoService.findUser(user_id);

        if(user == null){
            throw new UserNotFoundException("id-"+ user_id);
        }
        return  user;
    }

    @GetMapping( "/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable String id){
        userDaoService.deleteById(id);
    }

}
