package org.fy.accountservice.service.Impl;

import lombok.RequiredArgsConstructor;
import org.fy.accountservice.domain.entities.CostCenter;
import org.fy.accountservice.exception.AccountGroupNotFoundException;
import org.fy.accountservice.exception.CostCenterNotFoundException;
import org.fy.accountservice.repository.CostCenterRepository;
import org.fy.accountservice.service.CostCenterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class CostCenterServiceImpl implements CostCenterService {

    private final CostCenterRepository costCenterRepository;


    @Override
    public CostCenter create(CostCenter costCenter) {
        return costCenterRepository.save(costCenter);
    }

    @Override
    public CostCenter update(Long id, CostCenter costCenter) {
        CostCenter exisiting = costCenterRepository.findById(id)
                .orElseThrow(() -> new CostCenterNotFoundException("Cost Center Not Found"));

        exisiting.setName(costCenter.getName());
        exisiting.setDescription(costCenter.getDescription());

        return costCenterRepository.save(costCenter);
    }

    @Override
    public void delete(Long id) {
        costCenterRepository.deleteById(id);
    }

    @Override
    public CostCenter getById(Long id) {
        return costCenterRepository.findById(id)
                .orElseThrow(()-> new AccountGroupNotFoundException("CostCenter not found"));
    }

    @Override
    public List<CostCenter> getAll() {
        return costCenterRepository.findAll();
    }
}
