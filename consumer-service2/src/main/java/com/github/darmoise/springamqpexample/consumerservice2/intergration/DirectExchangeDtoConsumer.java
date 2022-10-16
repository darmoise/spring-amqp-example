package com.github.darmoise.springamqpexample.consumerservice2.intergration;

import com.github.darmoise.springamqpexample.consumerservice2.dto.DirectExchangeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DirectExchangeDtoConsumer {
    @RabbitListener(
        queues = "#{rabbitProperties.getQueues().getDirectQueue()}"
    )
    void onDirectExchangeDtoReceived(
        final DirectExchangeDto dto
    ) {
        log.info("onDirectExchangeDtoReceived, {}", dto.toString());
    }
}
