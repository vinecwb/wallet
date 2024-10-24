package com.juniorjourney.walletmanager.repositories;

import com.juniorjourney.walletmanager.domain.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}
