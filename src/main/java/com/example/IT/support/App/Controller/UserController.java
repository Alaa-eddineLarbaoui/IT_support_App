package com.example.IT.support.App.Controller;


import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/")
public class UserController {


    @Autowired
    private UserService userService;
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("get/{id}")
    public User GetUserById(@PathVariable Long id){
        return userService.getUser(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id ){
        userService.deleteUser(id);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return  userService.updateUser(id,user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("findByName")
    public  User getByName(@RequestParam String name){
        return userService.getUserByUsername(name);
    }

    @GetMapping("get_user/{username}")
    public User get_user(@PathVariable String username){
        return userService.getUser(username);
    }

}
