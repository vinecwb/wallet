package com.juniorjourney.walletmanager.service;

import com.juniorjourney.walletmanager.domain.wallet.Wallet;
import com.juniorjourney.walletmanager.domain.wallet.WalletRequestDTO;
import com.juniorjourney.walletmanager.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        wallet.setUser_id(walletRequestDTO.user_id());
        wallet.setEnabled(walletRequestDTO.enabled());
        wallet.setCreated_at(new Date());
        wallet.setUpdated_at(new Date());

        return walletRepository.save(wallet);
    }
}
