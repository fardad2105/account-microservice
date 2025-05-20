package org.fy.accountservice.domain.mapper;

import org.fy.accountservice.domain.dto.AccountGroupDto;
import org.fy.accountservice.domain.entities.AccountGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountGroupMapper {

    AccountGroupDto toDto(AccountGroup accountGroup);

    AccountGroup toEntity(AccountGroupDto accountGroupDto);

}
