package com.evan.springbootmvcsecurityhibernatemysql.web;

import com.evan.springbootmvcsecurityhibernatemysql.exception.UserNotFoundException;
import com.evan.springbootmvcsecurityhibernatemysql.model.User;
import com.evan.springbootmvcsecurityhibernatemysql.repository.UserRepository;
import com.evan.springbootmvcsecurityhibernatemysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        System.out.println("in post user page");
        System.out.println(newUser.getEmail() + "password: " + newUser.getPassword());
        return userService.saveUserDetail(newUser);
    }
    @GetMapping("/users")
    List<User> getAllUsers() {
        System.out.println("in users page");
        return userService.findAllUsers();
    }
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        System.out.println("in get " + id);
        return userService.findUserById(id);
    }
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        System.out.println(newUser);
        try {
            System.out.println("id: " + id + " new User " + newUser.getEmail());
            return userService.updateUserById(id, newUser);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        try {
            System.out.println("id: " + id);
            return userService.deleteUserById(id);
        } catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

}

