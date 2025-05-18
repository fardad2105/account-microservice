package org.fy.accountservice.service.Impl;

import lombok.RequiredArgsConstructor;
import org.fy.accountservice.domain.entities.Currency;
import org.fy.accountservice.exception.CurrencyNotFoundException;
import org.fy.accountservice.repository.CurrencyRepository;
import org.fy.accountservice.service.CurrencyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public Currency create(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency update(Long id, Currency currency) {
        Currency existing = currencyRepository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Currency not found"));

        existing.setCode(currency.getCode());
        existing.setName(currency.getName());
        existing.setSymbol(currency.getSymbol());
        return currencyRepository.save(currency);
    }

    @Override
    public void delete(Long id) {
        currencyRepository.deleteById(id);
    }

    @Override
    public Currency getById(Long id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Currency not found"));
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }
}
