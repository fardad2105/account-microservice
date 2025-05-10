package org.fy.accountservice.repository;

import org.fy.accountservice.domain.entities.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {
}
