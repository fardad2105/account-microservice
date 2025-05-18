package org.fy.accountservice.service;

import org.fy.accountservice.domain.entities.AccountGroup;

import java.util.List;

public interface AccountGroupService {

    AccountGroup create(AccountGroup group);
    AccountGroup update(long id, AccountGroup group);
    void delete(Long id);
    AccountGroup getById(Long id);
    List<AccountGroup> getAll();
}
