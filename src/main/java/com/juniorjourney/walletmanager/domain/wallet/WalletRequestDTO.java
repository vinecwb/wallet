package com.juniorjourney.walletmanager.domain.wallet;



import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record WalletRequestDTO(
        UUID id,
        int amount,
        @NotNull
        UUID user_id,
        boolean enabled,
        Date created_at,
        Date updated_at) {
}
