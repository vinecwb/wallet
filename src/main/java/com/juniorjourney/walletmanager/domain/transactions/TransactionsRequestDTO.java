package com.juniorjourney.walletmanager.domain.transactions;

import com.juniorjourney.walletmanager.domain.wallet.Wallet;

import java.util.Date;
import java.util.UUID;

public record TransactionsRequestDTO(
        UUID id,
        int amount,
        Action action,
        String source,
        Wallet wallet,
        Date createdAt
) {
}
