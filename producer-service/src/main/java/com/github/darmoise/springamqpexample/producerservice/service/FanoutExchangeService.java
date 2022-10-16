package com.github.darmoise.springamqpexample.producerservice.service;

import com.github.darmoise.springamqpexample.producerservice.domain.FanoutExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.integration.FanoutExchangeDtoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FanoutExchangeService {
    private final FanoutExchangeDtoProducer producer;

    public void send(FanoutExchangeModel model) {
        producer.sendToQueue(model);
    }
}
