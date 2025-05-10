package org.fy.accountservice.repository;

import org.fy.accountservice.domain.entities.AccountGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountGroupRepository extends JpaRepository<AccountGroup,Long> {
}
