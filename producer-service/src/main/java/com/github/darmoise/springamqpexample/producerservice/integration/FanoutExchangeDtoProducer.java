package com.github.darmoise.springamqpexample.producerservice.integration;

import com.github.darmoise.springamqpexample.producerservice.configuration.properties.RabbitProperties;
import com.github.darmoise.springamqpexample.producerservice.domain.DefaultExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.domain.FanoutExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.util.DefaultExchangeMapper;
import com.github.darmoise.springamqpexample.producerservice.util.FanoutExchangeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FanoutExchangeDtoProducer {
    private final AmqpTemplate template;
    private final RabbitProperties properties;
    private final FanoutExchangeMapper mapper;

    public void sendToQueue(FanoutExchangeModel model) {
        template.convertAndSend(
            properties.getExchanges().getProducerServiceFanoutExchange(),
            "",
            mapper.modelToDto(model)
        );
    }
}

