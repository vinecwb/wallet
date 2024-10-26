package com.juniorjourney.walletmanager.domain.wallet;

import jakarta.persistence.*;
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
    @Column(name = "user_id", nullable = false)
    private UUID userId;
    private boolean enabled;

    @Column(name = "created_at" )
    private Date createdAt;
    @Column(name = "updated_at" )
    private Date updatedAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
