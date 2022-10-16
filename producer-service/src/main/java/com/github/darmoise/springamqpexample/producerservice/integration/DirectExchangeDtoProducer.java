package com.github.darmoise.springamqpexample.producerservice.integration;

import com.github.darmoise.springamqpexample.producerservice.configuration.properties.RabbitProperties;
import com.github.darmoise.springamqpexample.producerservice.domain.DirectExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.util.DirectExchangeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DirectExchangeDtoProducer {
    private final AmqpTemplate template;
    private final RabbitProperties properties;
    private final DirectExchangeMapper mapper;

    public void sendToQueue(DirectExchangeModel model) {
        template.convertAndSend(
            properties.getExchanges().getProducerServiceDirectExchange(),
            model.serviceId(),
            mapper.modelToDto(model)
        );
    }
}

