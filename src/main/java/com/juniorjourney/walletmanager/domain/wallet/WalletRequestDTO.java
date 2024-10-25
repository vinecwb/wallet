package com.juniorjourney.walletmanager.domain.wallet;

import java.util.Date;
import java.util.UUID;

public record WalletRequestDTO(
        UUID id,
        int amount,
        UUID user_id,
        boolean enabled,
        Date created_at,
        Date updated_at) {
}
