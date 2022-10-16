package com.github.darmoise.springamqpexample.producerservice.util;

import com.github.darmoise.springamqpexample.producerservice.domain.FanoutExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.dto.FanoutExchangeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FanoutExchangeMapper {
    FanoutExchangeModel dtoToModel(FanoutExchangeDto dto);
    FanoutExchangeDto modelToDto(FanoutExchangeModel model);
}

