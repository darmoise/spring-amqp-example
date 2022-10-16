package com.github.darmoise.springamqpexample.consumerservice1.intergration;

import com.github.darmoise.springamqpexample.consumerservice1.dto.DefaultExchangeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultExchangeDtoConsumer {
    @RabbitListener(
        queues = "#{rabbitProperties.getQueues().getDefaultQueue()}"
    )
    void onDefaultExchangeDtoReceived(
        final DefaultExchangeDto dto
    ) {
        log.info("onDefaultExchangeDtoReceived, {}", dto.toString());
    }
}
