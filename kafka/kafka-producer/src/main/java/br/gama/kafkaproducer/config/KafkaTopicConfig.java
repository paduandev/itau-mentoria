package br.gama.kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    
    @Bean
    NewTopic myTopic() {
        return TopicBuilder.name("myTopic").build();
    }

    @Bean
    NewTopic newUser() {
        return TopicBuilder.name("newUser").build();
    }
}
