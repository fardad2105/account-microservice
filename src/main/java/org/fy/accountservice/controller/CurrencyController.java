package org.fy.accountservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fy.accountservice.domain.dto.CurrencyDto;
import org.fy.accountservice.domain.entities.Currency;
import org.fy.accountservice.domain.mapper.CurrencyMapper;
import org.fy.accountservice.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currencies")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;
    private final CurrencyMapper currencyMapper;

    @PostMapping
    public ResponseEntity<CurrencyDto> create(@RequestBody @Valid CurrencyDto currencyDto) {
        Currency entity = currencyMapper.toEntity(currencyDto);
        Currency saved = currencyService.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurrencyDto> update(@PathVariable Long id, @RequestBody @Valid CurrencyDto currencyDto) {
        Currency currency = currencyMapper.toEntity(currencyDto);
        Currency updated = currencyService.update(id,currency);
        return ResponseEntity.ok(currencyMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        currencyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CurrencyDto>> getAll() {
        return ResponseEntity.ok(currencyService.getAll()
                .stream().map(currencyMapper::toDto).toList());
    }
}
