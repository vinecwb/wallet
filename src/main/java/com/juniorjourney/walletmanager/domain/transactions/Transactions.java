package com.juniorjourney.walletmanager.domain.transactions;

import com.juniorjourney.walletmanager.domain.wallet.Wallet;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue
    private UUID id;
    private int amount;

    @Enumerated(EnumType.STRING)
    private Action action;

    private String source;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    // Construtor padrão
    public Transactions() {
    }

    // Construtor com todos os campos
    public Transactions(UUID id, int amount, Action action, String source, Date createdAt, Wallet wallet) {
        this.id = id;
        this.amount = amount;
        this.action = action;
        this.source = source;
        this.createdAt = createdAt;
        this.wallet = wallet;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    // Builder pode ser implementado manualmente, se necessário
}
