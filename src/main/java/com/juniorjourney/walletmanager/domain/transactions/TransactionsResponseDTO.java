package com.juniorjourney.walletmanager.domain.transactions;

import java.util.Date;
import java.util.UUID;

public record TransactionsResponseDTO(
        UUID id,
        int amount,
        Action action,
        String source,
        UUID walletId,
        Date createdAt
) {
}
