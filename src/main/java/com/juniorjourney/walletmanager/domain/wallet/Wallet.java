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
    private UUID user_id;
    private boolean enabled;

    @Column(name = "created_at" )
    private Date createdAt;
    @Column(name = "updated_at" )
    private Date updatedAt;

}
