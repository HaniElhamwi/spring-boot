package com.webapp.restfulwebservices.User;


import com.webapp.restfulwebservices.User.Post.Post;
import com.webapp.restfulwebservices.User.Post.PostRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserJpaResource {

    private UserDaoService userDaoService;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaResource(UserDaoService userDaoService , UserRepository userRepository , PostRepository postRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping( "/jpa/users/{user_id}")
    public User retrieveAllUser(@PathVariable int user_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new UserNotFoundException("id-"+ user_id));
        if(user == null){
            throw new UserNotFoundException("id-"+ user_id);
        }
        return  user;
    }

    @GetMapping( "/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}/posts")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForAUser(@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id-"+ id));

        if(user == null){
            throw new UserNotFoundException("id-"+ id);
        }

        return   user.getPosts();
    }


    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@Valid @RequestBody Post body , @PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id-"+ id));
        if(user == null){
            throw new UserNotFoundException("id-"+ id);
        }
        body.setUser(user);
    Post savedPost =postRepository.save(body);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

}
