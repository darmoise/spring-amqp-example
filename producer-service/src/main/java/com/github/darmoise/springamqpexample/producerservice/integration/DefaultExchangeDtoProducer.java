package com.github.darmoise.springamqpexample.producerservice.integration;

import com.github.darmoise.springamqpexample.producerservice.configuration.properties.RabbitProperties;
import com.github.darmoise.springamqpexample.producerservice.domain.DefaultExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.util.DefaultExchangeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultExchangeDtoProducer {
    private final AmqpTemplate template;
    private final RabbitProperties properties;
    private final DefaultExchangeMapper mapper;

    public void sendToQueue(DefaultExchangeModel model) {
        template.convertAndSend(
            properties.getRoutingKeys().getDefaultQueue(),
            mapper.modelToDto(model)
        );
    }
}
