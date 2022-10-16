package com.github.darmoise.springamqpexample.producerservice.domain;

import java.time.LocalDate;
import java.util.UUID;

public record FanoutExchangeModel(
    UUID requestId
) {

}
