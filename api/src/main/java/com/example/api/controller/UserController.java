package com.example.api.controller;

import com.example.api.dto.request.UserCreateRequest;
import com.example.api.dto.request.UserUpdateDTO;
import com.example.api.entities.User;
import com.example.api.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest userCreateRequest) throws JsonProcessingException {
        return new ResponseEntity<>(userService.createUser(userCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserUpdateDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) throws JsonProcessingException{
        return new ResponseEntity<>(userService.updateUser(userUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) throws JsonProcessingException {
        userService.deleteUser(id);
    }
}
