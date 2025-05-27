package org.fy.accountservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fy.accountservice.domain.dto.AccountGroupDto;
import org.fy.accountservice.domain.entities.AccountGroup;
import org.fy.accountservice.domain.mapper.AccountGroupMapper;
import org.fy.accountservice.service.AccountGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-groups")
@RequiredArgsConstructor
public class AccountGroupController {
    private final AccountGroupService accountGroupService;
    private final AccountGroupMapper accountGroupMapper;

    @PostMapping
    public ResponseEntity<AccountGroupDto> create(@RequestBody @Valid AccountGroupDto accountGroupDto) {
        AccountGroup entity = accountGroupService.create(accountGroupMapper.toEntity(accountGroupDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(accountGroupMapper.toDto(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountGroupDto> update(@PathVariable Long id, @RequestBody @Valid AccountGroupDto accountGroupDto) {
        AccountGroup entity = accountGroupMapper.toEntity(accountGroupDto);
        AccountGroup updated = accountGroupService.update(id,entity);
        return ResponseEntity.ok(accountGroupMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountGroupService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountGroupDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(accountGroupMapper.toDto(accountGroupService.getById(id)));
    }

    @GetMapping
    public ResponseEntity<List<AccountGroupDto>> getAll() {
        return ResponseEntity.ok(accountGroupService.getAll()
                .stream().map(accountGroupMapper::toDto).toList());
    }
}
