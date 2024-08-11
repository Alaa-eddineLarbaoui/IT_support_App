package com.example.IT.support.App.Controller;


import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("getUser/{id}")
    public User GetUserById(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable Long id ){
        userService.deleteUser(id);
    }

    @PutMapping("updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return  userService.updateUser(id,user);
    }
    @GetMapping("findByName")
    public  User getByName(@RequestParam String name){
        return userService.getUserByUsername(name);
    }
//@GetMapping("/search")
//public ResponseEntity<User> getUsersByName(@RequestParam String name) {
//    User users = userService.getUserByUsername(name);
//    if (!users.isEmpty()) {
//        return ResponseEntity.ok(users);
//    } else {
//        return ResponseEntity.noContent().build(); // 204 No Content si aucune correspondance n'est trouvée
//    }
//}
}
