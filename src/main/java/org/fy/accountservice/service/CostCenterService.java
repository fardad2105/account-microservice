package org.fy.accountservice.service;

import org.fy.accountservice.domain.entities.CostCenter;

import java.util.List;

public interface CostCenterService {

    CostCenter create(CostCenter costCenter);
    CostCenter update(Long id, CostCenter costCenter);
    void delete(Long id);
    CostCenter getById(Long id);
    List<CostCenter> getAll();
}
