package br.gama.kafkaproducer.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.gama.kafkaproducer.model.User;

@RestController
public class Controller {
    
    @Autowired
    private KafkaTemplate<String, String> templateString;
    @Autowired
    private KafkaTemplate<String, Serializable> templateUser;

    @GetMapping("/send/{msg}")
    public void send(@PathVariable String msg) {
        templateString.send("myTopic", msg);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        templateUser.send("newUser", user);
        return user;
    }
}
