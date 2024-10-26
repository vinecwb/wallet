package com.juniorjourney.walletmanager.service;

import com.juniorjourney.walletmanager.domain.wallet.Wallet;
import com.juniorjourney.walletmanager.domain.wallet.WalletRequestDTO;
import com.juniorjourney.walletmanager.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(WalletRequestDTO walletRequestDTO) {
        Wallet wallet = new Wallet();
        wallet.setAmount(walletRequestDTO.amount());
        wallet.setUserId(walletRequestDTO.userId());
        wallet.setEnabled(walletRequestDTO.enabled());
        wallet.setCreatedAt(new Date());
        wallet.setUpdatedAt(new Date());

        return walletRepository.save(wallet);
    }

    public Optional<Wallet> getWalletById(UUID id) {
        return walletRepository.findById(id);
    }
}
