package com.example.database.service;

import com.example.database.dto.UpdateUserDTO;
import com.example.database.entity.User;
import com.example.database.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, ObjectMapper objectMapper){
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }
    public String addUser(String msg) throws JsonProcessingException {
        User user = objectMapper.readValue(msg, User.class);
        userRepository.save(user);
        return "User Added";
    }

    public String updateUser(String msg) throws JsonProcessingException {
        UpdateUserDTO updateUserDTO = objectMapper.readValue(msg, UpdateUserDTO.class);

        Optional<User> foundUser = userRepository.findById(updateUserDTO.getId());
        if (foundUser.isPresent()){
            User user = foundUser.get();
            user.setJob(updateUserDTO.getJob());
            return "User Updated";
        }else {
            return "User update failed";
        }
    }

    public String deleteUser(String msg) {
        if(msg != null){
            Long id = Long.parseLong(msg);
            userRepository.deleteById(id);
            return "Delete success";
        }else {
            return "Delete failed";
        }
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
