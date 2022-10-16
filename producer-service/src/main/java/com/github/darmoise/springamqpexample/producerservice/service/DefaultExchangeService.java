package com.github.darmoise.springamqpexample.producerservice.service;

import com.github.darmoise.springamqpexample.producerservice.domain.DefaultExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.integration.DefaultExchangeDtoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultExchangeService {
    private final DefaultExchangeDtoProducer producer;

    public void send(DefaultExchangeModel model) {
        producer.sendToQueue(model);
    }
}
