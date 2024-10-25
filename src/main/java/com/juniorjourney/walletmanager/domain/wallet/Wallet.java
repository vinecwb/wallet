package com.juniorjourney.walletmanager.domain.wallet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "wallet")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue
    private UUID id;
    private int amount;
    private UUID userId;
    private boolean status;
    private Date createdAt;
    private Date updatedAt;

}
