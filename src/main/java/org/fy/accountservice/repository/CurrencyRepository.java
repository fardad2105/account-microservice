package org.fy.accountservice.repository;

import org.fy.accountservice.domain.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
