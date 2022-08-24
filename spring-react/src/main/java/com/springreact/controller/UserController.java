package com.springreact.controller;

import com.springreact.model.projection.UserProjection;
import com.springreact.request.UserRequest;
import com.springreact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<UserProjection> getAllUser(){
        return new ResponseEntity(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserProjection> addUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity(userService.addUser(userRequest), HttpStatus.CREATED);
    }
}
