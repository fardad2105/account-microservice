package org.fy.accountservice.service.Impl;

import lombok.RequiredArgsConstructor;
import org.fy.accountservice.domain.entities.Account;
import org.fy.accountservice.exception.AccountNotFoundException;
import org.fy.accountservice.repository.AccountRepository;
import org.fy.accountservice.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Account account) {
        Account existing = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        existing.setTitle(account.getTitle());
        existing.setCode(account.getCode());
        existing.setType(account.getType());
        existing.setGroup(account.getGroup());
        existing.setCurrency(account.getCurrency());
        existing.setCostCenter(account.getCostCenter());

        return accountRepository.save(existing);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
