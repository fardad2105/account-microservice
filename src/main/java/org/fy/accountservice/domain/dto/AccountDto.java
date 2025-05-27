package org.fy.accountservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fy.accountservice.domain.enums.AccountType;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    private Long id;
    private String code;
    private String title;
    private AccountType type;
    private boolean active;
    private Integer level;
}
