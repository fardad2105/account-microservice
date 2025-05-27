package org.fy.accountservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fy.accountservice.domain.dto.CostCenterDto;
import org.fy.accountservice.domain.entities.CostCenter;
import org.fy.accountservice.domain.mapper.CostCenterMapper;
import org.fy.accountservice.service.CostCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cost-centers")
@RequiredArgsConstructor
public class CostCenterController {

    private final CostCenterService costCenterService;
    private final CostCenterMapper costCenterMapper;


    @PostMapping
    public ResponseEntity<CostCenterDto > create(@RequestBody @Valid CostCenterDto costCenterDto) {
        CostCenter costCenter = costCenterMapper.toEntity(costCenterDto);
        CostCenter saved = costCenterService.create(costCenter);
        return ResponseEntity.status(HttpStatus.CREATED).body(costCenterMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostCenterDto> update(@PathVariable Long id, @RequestBody @Valid CostCenterDto costCenterDto) {
        CostCenter costCenter = costCenterMapper.toEntity(costCenterDto);
        CostCenter updated = costCenterService.update(id,costCenter);

        return ResponseEntity.ok(costCenterMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        costCenterService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostCenterDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(costCenterMapper.toDto(costCenterService.getById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CostCenterDto>> getAll() {
        return ResponseEntity.ok(costCenterService.getAll()
                .stream().map(costCenterMapper::toDto).toList());
    }
}
