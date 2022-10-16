package com.github.darmoise.springamqpexample.consumerservice2.dto;

import java.time.LocalDate;
import java.util.UUID;

public record FanoutExchangeDto(
    UUID requestId
) {

}
