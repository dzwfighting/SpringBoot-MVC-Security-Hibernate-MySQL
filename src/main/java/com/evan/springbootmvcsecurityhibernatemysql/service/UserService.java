package com.evan.springbootmvcsecurityhibernatemysql.service;

import com.evan.springbootmvcsecurityhibernatemysql.exception.UserNotFoundException;
import com.evan.springbootmvcsecurityhibernatemysql.model.User;
import com.evan.springbootmvcsecurityhibernatemysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;


    public User saveUserDetail(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.getById(id);
    }

    public User updateUserById(Long id, User newUser) throws UserNotFoundException {
        return userRepository.findById(id).map(user -> {
            user.setEmail(newUser.getEmail());
            user.setPassword((newUser.getPassword()));
            return userRepository.save(user);
        }).orElseThrow(()->new UserNotFoundException(id));
    }

    public String deleteUserById(Long id) throws UserNotFoundException {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id: " + id + " has been deleted successfully!";
    }
}
