package com.github.darmoise.springamqpexample.producerservice.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(
        final ObjectMapper objectMapper
    ) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(
        final ConnectionFactory connectionFactory,
        final Jackson2JsonMessageConverter jackson2JsonMessageConverter
    ) {
        val rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);
        return rabbitTemplate;
    }
}
