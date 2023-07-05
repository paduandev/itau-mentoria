package br.gama.kafkaconsumer.listeners;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gama.kafkaconsumer.model.User;

@Component
public class KafkaListeners {
    
    @KafkaListener(id="myGroup1", topics = "myTopic")
    public void listenString(String msg) {
        System.out.println("Recebido: " + msg);
    }

    @KafkaListener(id="myGroup2", topics = "newUser")
    public void listenUser(String userString) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(userString, User.class);

        System.out.println("Recebido: " + user);
    }


}
