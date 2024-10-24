package com.juniorjourney.walletmanager.repositories;

import com.juniorjourney.walletmanager.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
