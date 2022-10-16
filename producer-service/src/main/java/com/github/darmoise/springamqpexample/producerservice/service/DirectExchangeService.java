package com.github.darmoise.springamqpexample.producerservice.service;

import com.github.darmoise.springamqpexample.producerservice.domain.DirectExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.integration.DirectExchangeDtoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectExchangeService {
    private final DirectExchangeDtoProducer producer;

    public void send(DirectExchangeModel model) {
        producer.sendToQueue(model);
    }
}
