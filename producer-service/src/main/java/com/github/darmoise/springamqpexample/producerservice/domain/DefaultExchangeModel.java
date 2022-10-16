package com.github.darmoise.springamqpexample.producerservice.domain;

import java.util.UUID;

public record DefaultExchangeModel(
    UUID requestId
) {
}
