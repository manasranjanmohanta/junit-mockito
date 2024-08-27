package com.example.demo.JavaTechie.service;

import com.example.demo.JavaTechie.dao.UserRepository;
import com.example.demo.JavaTechie.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUserByAddress(String address) {
        return userRepository.findByAddress(address);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
