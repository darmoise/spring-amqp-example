package com.github.darmoise.springamqpexample.consumerservice1.dto;

import java.time.LocalDate;
import java.util.UUID;

public record FanoutExchangeDto(
    UUID requestId
) {

}
