package com.github.darmoise.springamqpexample.consumerservice2.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.darmoise.springamqpexample.consumerservice2.configuration.properties.RabbitProperties;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfiguration {
    private final RabbitProperties properties;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(
        final ObjectMapper objectMapper
    ) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(
        final ConnectionFactory connectionFactory,
        final Jackson2JsonMessageConverter converter
    ) {
        val rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(
        final ConnectionFactory connectionFactory
    ) {
        val factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    // Fanout exchange
    @Bean
    public Queue fanoutQueue() {
        return new Queue(properties.getQueues().getFanoutQueue());
    }

    @Bean
    public FanoutExchange producerServiceFanoutExchange() {
        return new FanoutExchange(properties.getExchanges().getProducerServiceFanoutExchange());
    }

    @Bean
    public Binding bindingFanoutBinding(
        final FanoutExchange producerServiceFanoutExchange,
        final Queue fanoutQueue
    ) {
        return BindingBuilder.bind(fanoutQueue).to(producerServiceFanoutExchange);
    }

    // Direct exchange
    @Bean
    public Queue directQueue() {
        return new Queue(properties.getQueues().getDirectQueue());
    }

    @Bean
    public DirectExchange producerServiceDirectExchange() {
        return new DirectExchange(properties.getExchanges().getProducerServiceDirectExchange());
    }

    @Bean
    public Binding bindingDirectBinding(
        final DirectExchange producerServiceDirectExchange,
        final Queue directQueue
    ) {
        return BindingBuilder.bind(directQueue)
            .to(producerServiceDirectExchange)
            .with(properties.getRoutingKeys().getDirectQueue());
    }
}
