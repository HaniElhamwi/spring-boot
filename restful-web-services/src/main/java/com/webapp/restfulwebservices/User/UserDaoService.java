package com.webapp.restfulwebservices.User;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private  static List<User> users = new ArrayList<>();
    private static int userCount = 5;

    static {
        users.add(new User(1, "Adam", null));
        users.add(new User(2, "Eve", null));
        users.add(new User(3, "Jack", null));
        users.add(new User(4, "Jill", null));
        users.add(new User(5, "John", null));

    }

    public List<User> findAll() {
        return users;
    }

    public User findUser(int id) {
        for (User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

//    public User findOne(int id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        return users.stream().filter(predicate).findFirst().get();
//    }

    public User save( User user){
        user.setId(++userCount);
       users.add(user);
       return user;
    }


    public  void deleteById(String id){
        users.removeIf(user -> id.equals(String.valueOf(user.getId())));
    }

    public User findOne(int user_id) {
        return users.stream().filter(user -> user.getId() == user_id).findFirst().get();
    }
}
