package com.github.darmoise.springamqpexample.producerservice.util;

import com.github.darmoise.springamqpexample.producerservice.domain.DefaultExchangeModel;
import com.github.darmoise.springamqpexample.producerservice.dto.DefaultExchangeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DefaultExchangeMapper {
    DefaultExchangeModel dtoToModel(DefaultExchangeDto dto);
    DefaultExchangeDto modelToDto(DefaultExchangeModel model);
}
