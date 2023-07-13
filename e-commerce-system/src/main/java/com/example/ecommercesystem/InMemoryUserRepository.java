package com.example.ecommercesystem;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryUserRepository implements UserRepository {

    //Here userMap takes as the database
    Map<Integer,User> userMap = new HashMap<>(); //put users in a (list) map->Can query by the id.

    public InMemoryUserRepository(){
        User user1 = new User();
        user1.id = 1;
        user1.name = "Kimal";
        user1.age = 30;
        userMap.put(1,user1);

        User user2 = new User();
        user2.id = 2;
        user2.name = "Kasun";
        user2.age = 32;
        userMap.put(2,user2);

    }
    @Override
    //get the user by ID
    public User getUserByID(int id) {

        return userMap.get(id);

        /*
            //query the database and fetch user
             User user = new User();
            user.name = "Nimal";
            user.age = 20;
            user.id = 35;
            return user;
         */
    }

    //add a new user to the database
    public void save (User user){
        userMap.put(user.id,user);
    }

    //update a user
    @Override
    public void updateUser (User user){
        userMap.put(user.id,user);
    }

    //delete user
    @Override
    public void deleteUser(int id){
        userMap.remove(id);
    }

}
