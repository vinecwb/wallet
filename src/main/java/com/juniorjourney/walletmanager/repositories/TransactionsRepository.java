package com.juniorjourney.walletmanager.repositories;

import com.juniorjourney.walletmanager.domain.transactions.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionsRepository extends JpaRepository<Transactions, UUID> {
}
