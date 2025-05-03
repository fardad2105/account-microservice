package org.fy.accountservice.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.fy.accountservice.domain.enums.AccountType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Setter
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Account parent;

    private Integer level;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private AccountGroup group;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "cost_center_id")
    private CostCenter costCenter;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

}
