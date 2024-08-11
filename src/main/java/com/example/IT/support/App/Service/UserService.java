package com.example.IT.support.App.Service;

import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public User updateUser(Long id, User user) {
        User us = getUser(id);
        us.setUsername(user.getUsername());
        us.setEmail(user.getEmail());
        us.setPassword(user.getPassword());
        return userRepository.save(us);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found."));
    }

}



