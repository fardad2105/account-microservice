package org.fy.accountservice.domain.mapper;

import org.fy.accountservice.domain.dto.CostCenterDto;
import org.fy.accountservice.domain.entities.CostCenter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CostCenterMapper {
    CostCenterDto toDto(CostCenter costCenter);
    CostCenter toEntity(CostCenterDto costCenterDto);
}
