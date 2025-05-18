package org.fy.accountservice.service;

import org.fy.accountservice.domain.entities.Currency;

import java.util.List;

public interface CurrencyService {

    Currency create(Currency currency);
    Currency update(Long id, Currency currency);
    void delete(Long id);
    Currency getById(Long id);
    List<Currency> getAll();
}
