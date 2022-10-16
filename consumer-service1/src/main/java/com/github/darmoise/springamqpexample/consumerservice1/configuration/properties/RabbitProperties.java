package com.github.darmoise.springamqpexample.consumerservice1.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitProperties{
    private Queues queues;
    private RoutingKeys routingKeys;
    private Exchanges exchanges;

    @Data
    public static class Queues {
        private String defaultQueue;
        private String fanoutQueue;
        private String directQueue;
    }
    @Data
    public static class RoutingKeys {
        private String directQueue;
    }
    @Data
    public static class Exchanges {
        private String producerServiceFanoutExchange;
        private String producerServiceDirectExchange;
    }

}
