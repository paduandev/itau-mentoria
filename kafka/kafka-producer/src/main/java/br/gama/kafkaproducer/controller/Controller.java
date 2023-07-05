package br.gama.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private KafkaTemplate<String, String> templateString;

    @GetMapping("/send/{msg}")
    public void send(@PathVariable String msg) {
        templateString.send("myTopic", msg);
    }
}
