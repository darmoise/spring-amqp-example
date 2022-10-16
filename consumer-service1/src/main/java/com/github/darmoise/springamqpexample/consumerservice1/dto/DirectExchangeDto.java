package com.github.darmoise.springamqpexample.consumerservice1.dto;

import java.util.UUID;

public record DirectExchangeDto(
    UUID requestId,
    String serviceId
) { }
