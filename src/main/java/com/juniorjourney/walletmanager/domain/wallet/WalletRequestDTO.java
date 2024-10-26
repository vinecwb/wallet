package com.juniorjourney.walletmanager.domain.wallet;



import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record WalletRequestDTO(
        UUID id,
        int amount,
        @NotNull
        UUID userId,
        boolean enabled,
        Date createdAt,
        Date updatedAt) {
}
