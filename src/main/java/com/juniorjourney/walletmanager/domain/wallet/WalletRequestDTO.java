package com.juniorjourney.walletmanager.domain.wallet;

import java.util.Date;
import java.util.UUID;

public record WalletRequestDTO(UUID id, int amount, UUID userId, boolean status, Date createdAt, Date updatedAt) {
}
