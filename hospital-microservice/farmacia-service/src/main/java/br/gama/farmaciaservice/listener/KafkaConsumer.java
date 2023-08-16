package br.gama.farmaciaservice.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class KafkaConsumer {
    
    @KafkaListener(id ="group1", topics = "receitas")
    public void print(String receita) {
        log.info("Receita recebida: {}", receita);
    }
}
