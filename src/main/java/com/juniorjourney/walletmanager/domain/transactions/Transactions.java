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
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue
    private UUID id;
    private int amount;
    @Enumerated(EnumType.STRING)
    private Action action;
    private String source;
    @Column(name = "created_at" )
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;


    public Transactions(int amount, Action action, String source, Wallet wallet, Date createdAt) {
        this.amount = amount;
        this.action = action;
        this.source = source;
        this.wallet = wallet;
        this.createdAt = createdAt;
    }
}


