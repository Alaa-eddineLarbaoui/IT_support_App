package com.example.IT.support.App.Controller;


import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user/")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();

    }
    @GetMapping("{id}")
    public User GetUserById(@PathVariable() Long id){
        return userService.getUserById(id);
    }


}
