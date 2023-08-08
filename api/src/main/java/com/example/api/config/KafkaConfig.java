package com.example.api.config;

import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
public class KafkaConfig {

    private KafkaProperties kafkaProperties;

    //@Value("${topic.name}")
    public static String topicName = "user_topic";

    public static String updateTopic = "user_update";

    public static String deleteTopic = "user_delete";

    public KafkaConfig(KafkaProperties kafkaProperties){
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String,Object> properties = kafkaProperties.buildProducerProperties();
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }


    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topicName)
                .partitions(1)
                .replicas(1) // topic bir kere yedeklenecek
                .build();
    }

    @Bean
    public NewTopic updateTopic() {
        return TopicBuilder.name(updateTopic)
                .partitions(1)
                .replicas(1) // topic bir kere yedeklenecek
                .build();
    }

    @Bean
    public NewTopic deleteTopic() {
        return TopicBuilder.name(deleteTopic)
                .partitions(1)
                .replicas(1) // topic bir kere yedeklenecek
                .build();
    }
}
