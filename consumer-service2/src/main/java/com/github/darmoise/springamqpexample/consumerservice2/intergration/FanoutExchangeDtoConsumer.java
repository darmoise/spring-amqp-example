package com.github.darmoise.springamqpexample.consumerservice2.intergration;

import com.github.darmoise.springamqpexample.consumerservice2.dto.FanoutExchangeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FanoutExchangeDtoConsumer {
    @RabbitListener(
        queues = "#{rabbitProperties.getQueues().getFanoutQueue()}"
    )
    void onFanoutExchangeDtoReceived(
        final FanoutExchangeDto dto
    ) {
        log.info("onFanoutExchangeDtoReceived, {}", dto.toString());
    }
}
