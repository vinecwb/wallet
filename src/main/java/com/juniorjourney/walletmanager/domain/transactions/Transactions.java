package com.juniorjourney.walletmanager.domain.transactions;

import com.juniorjourney.walletmanager.domain.wallet.Wallet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue
    private UUID id;
    private int amount;
    private String action;
    private String source;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;


}
