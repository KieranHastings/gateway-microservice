package com.helloworldapi.helloworld_api.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helloworldapi.helloworld_api.Entity.User;
import com.helloworldapi.helloworld_api.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UserController {
    
    UserService userService;
    
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(){

        return new ResponseEntity<>(userService.getListOfUsers(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<HttpStatus> saveUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    
}
