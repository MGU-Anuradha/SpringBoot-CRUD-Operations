package com.example.ecommercesystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//one controller class can contain any number of endpoints
//an endpoint is single responsible (usually)
// An endpoint is a method
@RestController
public class UserController {


    UserRepository userRepository;
    @Autowired //using dependency injection
    UserController(UserRepository repository){
        this.userRepository = repository;
    }


    //get user endpoint--------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------
    @GetMapping("/user") //HTTP GET method
    public User getUser(@RequestParam int id){

        //get the user from the database
        return userRepository.getUserByID(id);

        //and return

    } //give the output which related to requested id


    /*
    @GetMapping("/user") //HTTP GET method
    public User getUser(@RequestParam int id){
        User user = new User();
        user.name = "Nimal";
        user.age = 20;
        user.id = id;
        return user;
    } //give the output which related to requested id
    ------------------------------------------------------*/

    /*
        @GetMapping("/user") //HTTP GET method
        public User getUser(){
            User user = new User();
            user.name = "Nimal";
            user.age = 20;
            user.id = 12345;
            return user;
        } //get output as a jason object
       ----------------------------------------------------*/

    /*
    @GetMapping("/user") //HTTP GET method
    public String getUser(){
        return "Hello World";
    } //localhost:8080/user  --> displays Hello World
    */




    //add user endpoint (user registration) -----------------------------------------------------------
    //-------------------------------------------------------------------------------------------------
    @PostMapping("/user")
    public void addUser(@RequestBody User user){

        //do validations--------------------------
        //whether the user is already registered
        user.emailVerified = false;

        //send an email to the user - call an external email service for this

        userRepository.save(user);
    }



    //update user endpoint ---------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------
    @PatchMapping("/user")
    public void updateUser(@RequestBody User user){
        userRepository.updateUser(user);
    }


    //delete a user endpoint ------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam int id){
        userRepository.deleteUser(id);
    }

}
