package com.juniorjourney.walletmanager.domain.wallet;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "wallet")
@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private UUID id;
    private int amount;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    private boolean enabled;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    // Construtor padrão
    public Wallet() {
    }

    // Construtor com todos os campos
    public Wallet(UUID id, int amount, UUID userId, boolean enabled, Date createdAt, Date updatedAt) {
        this.id = id;
        this.amount = amount;
        this.userId = userId;
        this.enabled = enabled;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Métodos para manipulação de dados antes de persistir
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
