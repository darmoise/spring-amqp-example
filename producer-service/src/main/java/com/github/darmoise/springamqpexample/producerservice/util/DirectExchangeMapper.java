package com.github.darmoise.springamqpexample.producerservice.util;

import com.github.darmoise.springamqpexample.producerservice.domain.DirectExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.dto.DirectExchangeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectExchangeMapper {
    DirectExchangeModel dtoToModel(DirectExchangeDto dto);
    DirectExchangeDto modelToDto(DirectExchangeModel model);
}
