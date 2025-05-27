package org.fy.accountservice.domain.mapper;

import org.fy.accountservice.domain.dto.AccountDto;
import org.fy.accountservice.domain.entities.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto(Account account);
    Account toEntity(AccountDto accountDto);
}
