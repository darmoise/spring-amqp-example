package com.github.darmoise.springamqpexample.producerservice.controller;

import com.github.darmoise.springamqpexample.producerservice.dto.DefaultExchangeDto;
import com.github.darmoise.springamqpexample.producerservice.dto.DirectExchangeDto;
import com.github.darmoise.springamqpexample.producerservice.dto.FanoutExchangeDto;
import com.github.darmoise.springamqpexample.producerservice.service.DefaultExchangeService;
import com.github.darmoise.springamqpexample.producerservice.service.DirectExchangeService;
import com.github.darmoise.springamqpexample.producerservice.service.FanoutExchangeService;
import com.github.darmoise.springamqpexample.producerservice.util.DefaultExchangeMapper;
import com.github.darmoise.springamqpexample.producerservice.util.DirectExchangeMapper;
import com.github.darmoise.springamqpexample.producerservice.util.FanoutExchangeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${service.rest-api}/rabbitmq")
public class Controller {
    private final DefaultExchangeMapper defaultExchangeMapper;
    private final FanoutExchangeMapper fanoutExchangeMapper;
    private final DirectExchangeMapper directExchangeMapper;
    private final DefaultExchangeService defaultExchangeService;
    private final FanoutExchangeService fanoutExchangeService;
    private final DirectExchangeService directExchangeService;

    @PostMapping("default-exchange")
    void sentToQueueAThroughDefaultExchange(DefaultExchangeDto dto) {
        defaultExchangeService.send(
            defaultExchangeMapper.dtoToModel(dto)
        );
    }

    @PostMapping("fanout-exchange")
    void sentToQueuesThroughFanoutExchange(FanoutExchangeDto dto) {
        fanoutExchangeService.send(
            fanoutExchangeMapper.dtoToModel(dto)
        );
    }

    @PostMapping("direct-exchange")
    void sendToQueuesThroughDirectExchange(DirectExchangeDto dto) {
        directExchangeService.send(
            directExchangeMapper.dtoToModel(dto)
        );
    }
}
