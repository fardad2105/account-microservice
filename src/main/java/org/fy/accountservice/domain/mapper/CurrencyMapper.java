package org.fy.accountservice.domain.mapper;

import org.fy.accountservice.domain.dto.CurrencyDto;
import org.fy.accountservice.domain.entities.Currency;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    CurrencyDto toDto(Currency currency);
    Currency toEntity(CurrencyDto currencyDto);
}
