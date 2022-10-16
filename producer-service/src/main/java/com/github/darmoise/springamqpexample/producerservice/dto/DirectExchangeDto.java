package com.github.darmoise.springamqpexample.producerservice.dto;

import java.util.UUID;

public record DirectExchangeDto(
    UUID requestId,
    String serviceId
) { }
