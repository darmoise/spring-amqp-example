package com.github.darmoise.springamqpexample.producerservice.dto;

import java.time.LocalDate;
import java.util.UUID;

public record DefaultExchangeDto(
    UUID requestId
) {
}
