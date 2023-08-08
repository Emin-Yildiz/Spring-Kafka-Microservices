package com.example.database.Listener;

import com.example.database.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserListener {

    private final UserService userService;

    public UserListener(UserService userService){
        this.userService = userService;
    }

    @KafkaListener(topics = "user_topic", groupId = "group-id")
    public void userListener(String msg) throws JsonProcessingException {
        log.info(msg);
        userService.addUser(msg);
    }

    @KafkaListener(topics = "user_update", groupId = "group-id")
    public void updateListener(String msg) throws JsonProcessingException {
        log.info(msg);
        userService.updateUser(msg);
    }

    @KafkaListener(topics = "user_delete", groupId = "group-id")
    public void deleteListener(String msg) throws JsonProcessingException {
        log.info(msg);
        userService.deleteUser(msg);
    }
}
