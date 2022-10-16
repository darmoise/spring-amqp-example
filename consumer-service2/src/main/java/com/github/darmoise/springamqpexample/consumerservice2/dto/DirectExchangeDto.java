package com.github.darmoise.springamqpexample.consumerservice2.dto;

import java.util.UUID;

public record DirectExchangeDto(
    UUID requestId,
    String serviceId
) { }
