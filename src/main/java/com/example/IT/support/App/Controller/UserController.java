package com.example.IT.support.App.Controller;


import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();

    }
    @GetMapping("get/{id}")
    public User GetUserById(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id ){
        userService.deleteUser(id);
    }

    @PutMapping("update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return  userService.updateUser(id,user);
    }
    @GetMapping("findByName")
    public  User getByName(@RequestParam String name){
        return userService.getUserByUsername(name);
    }

}
