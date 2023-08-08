package com.example.api.service;

import com.example.api.config.KafkaConfig;
import com.example.api.dto.request.UserCreateRequest;
import com.example.api.dto.request.UserUpdateDTO;
import com.example.api.dto.response.UserCreateResponse;
import com.example.api.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public UserService(KafkaTemplate<String,String> kafkaTemplate, ObjectMapper objectMapper){
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public List<UserCreateResponse> getUsers(){
        return null;
    }

    public User createUser(UserCreateRequest userCreateRequest) throws JsonProcessingException {
        if(userCreateRequest != null){
            User user = new User();
            user.setName(userCreateRequest.getName());
            user.setAge(userCreateRequest.getAge());
            user.setJob(userCreateRequest.getJob());
            sendUser(user);
            return user;
        }else {
            return null;
        }
    }

    public UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO) throws JsonProcessingException {
        if (userUpdateDTO != null){
            sendUpdateUser(userUpdateDTO);
            return userUpdateDTO;
        }else {
            return null;
        }
    }

    private void sendUpdateUser(UserUpdateDTO userUpdateDTO) throws JsonProcessingException {
        String updateMsg = objectMapper.writeValueAsString(userUpdateDTO);
        kafkaTemplate.send(KafkaConfig.updateTopic,updateMsg);
    }

    public void sendUser(User user) throws JsonProcessingException {
        String userMsg = objectMapper.writeValueAsString(user);
        kafkaTemplate.send(KafkaConfig.topicName,userMsg);
    }

    public void deleteUser(Long id) throws JsonProcessingException {
        String deleteMsg = objectMapper.writeValueAsString(id);
        kafkaTemplate.send(KafkaConfig.deleteTopic,deleteMsg);
    }
}
