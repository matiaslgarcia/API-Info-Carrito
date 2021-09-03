package com.informatorio.Carrito.controller;

import com.informatorio.Carrito.entity.User;
import com.informatorio.Carrito.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    
    private UserService userService;
    
    public UserController(UserService userService) { 
        this.userService = userService; 
    }

    @PostMapping
    public ResponseEntity<?> createUser (@RequestBody User newUser){
        return new ResponseEntity<> (userService.createUser(newUser), HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
    
    @GetMapping(value ="/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        return userService.findUserById(userId);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable("id") Long userId){
        User userDelete = userService.findUserById(userId);
        userService.deleteUser(userDelete);
    }
    
    @PutMapping(value = "/{id}")
    public User updateUserById(@PathVariable("id") Long userId, @RequestBody User userToUpdate){
        User user = userService.findUserById(userId);
        return userService.updateUser(user ,userToUpdate);
    }
}
