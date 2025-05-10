package org.fy.accountservice.service;

import org.fy.accountservice.domain.entities.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    Account updateAccount(Long id, Account account);

    void deleteAccount(Long id);

    Account getAccount(Long id);

    List<Account> getAllAccounts();
}
