package org.fy.accountservice.service.Impl;

import lombok.RequiredArgsConstructor;
import org.fy.accountservice.domain.entities.AccountGroup;
import org.fy.accountservice.exception.AccountGroupNotFoundException;
import org.fy.accountservice.repository.AccountGroupRepository;
import org.fy.accountservice.service.AccountGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountGroupServiceImpl implements AccountGroupService {

    private final AccountGroupRepository accountGroupRepository;

    @Override
    public AccountGroup create(AccountGroup group) {
        return accountGroupRepository.save(group);
    }

    @Override
    public AccountGroup update(long id, AccountGroup group) {
        AccountGroup existing = accountGroupRepository.findById(id)
                .orElseThrow(() -> new AccountGroupNotFoundException("AccountGroup not found"));

        existing.setName(group.getName());
        existing.setDescription(group.getDescription());
        return accountGroupRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        accountGroupRepository.deleteById(id);
    }

    @Override
    public AccountGroup getById(Long id) {
        return accountGroupRepository.findById(id)
                .orElseThrow(() -> new AccountGroupNotFoundException("AccountGroup not found"));
    }

    @Override
    public List<AccountGroup> getAll() {
        return accountGroupRepository.findAll();
    }
}
