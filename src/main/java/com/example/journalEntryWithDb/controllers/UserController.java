package com.example.journalEntryWithDb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.journalEntryWithDb.entity.UserEntity;
import com.example.journalEntryWithDb.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    // private UserService userService = new UserService();

    // Add an user to database
    @PostMapping("/addUser")
    public ResponseEntity<Boolean> addUser(@RequestBody UserEntity userEntity) {
        Boolean isAdded = userService.addUser(userEntity, userEntity.getUsername());
        return new ResponseEntity<>(isAdded ? true : false, isAdded ? HttpStatus.CREATED : HttpStatus.IM_USED);
    }

    // Find all users
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserEntity>> getUsers() {
        // return new ResponseEntity<>(UserService.getAllUsers(), HttpStatus.OK); //
        // Static
        // OR
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Find user with a particular username
    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<UserEntity> findByUserName(@PathVariable String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    // Update an user
    @PostMapping("/updateUser/{username}")
    public ResponseEntity<Boolean> updateUser(@RequestBody UserEntity userEntity, @PathVariable String username){
        Boolean isUpdated = userService.updateUser(userEntity, username);
        return new ResponseEntity<>(isUpdated ? true : false, isUpdated ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    // Delete an user
    @DeleteMapping("/deleteUser/{username}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String username) {
        Boolean isDeleted = userService.deleteUser(username);
        return new ResponseEntity<>(isDeleted ? true : false, isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
