package com.juniorjourney.walletmanager.service;

import com.juniorjourney.walletmanager.domain.transactions.Action;
import com.juniorjourney.walletmanager.domain.transactions.Transactions;
import com.juniorjourney.walletmanager.domain.transactions.TransactionsRequestDTO;
import com.juniorjourney.walletmanager.domain.wallet.Wallet;

import com.juniorjourney.walletmanager.repositories.TransactionsRepository;
import com.juniorjourney.walletmanager.repositories.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TransactionsService {

    private final WalletRepository walletRepository;
    private final TransactionsRepository transactionsRepository;

    public TransactionsService(WalletRepository walletRepository, TransactionsRepository transactionsRepository) {
        this.walletRepository = walletRepository;
        this.transactionsRepository = transactionsRepository;
    }

    @Transactional
    public Transactions createTransaction(TransactionsRequestDTO transactionsRequestDTO) {
        Wallet wallet = transactionsRequestDTO.wallet();

        if (transactionsRequestDTO.action() == Action.INCREMENT) {
            wallet.setAmount(wallet.getAmount() + transactionsRequestDTO.amount());
        } else if (transactionsRequestDTO.action() == Action.DECREMENT) {
            if (wallet.getAmount() >= transactionsRequestDTO.amount()) {
                wallet.setAmount(wallet.getAmount() - transactionsRequestDTO.amount());
            } else {
                throw new IllegalArgumentException("Saldo insuficiente na carteira");
            }
        }

        if (wallet.getCreatedAt() == null) {
            wallet.setCreatedAt(new Date());
        }

        walletRepository.save(wallet);
        if (wallet.getUserId() == null) {
            throw new IllegalArgumentException("user_id não pode ser nulo");
        }


        Transactions transaction = Transactions.builder()
                .amount(transactionsRequestDTO.amount())
                .action(transactionsRequestDTO.action())
                .source(transactionsRequestDTO.source())
                .wallet(wallet)
                .createdAt(wallet.getCreatedAt())
                .build();

        return transactionsRepository.save(transaction);
    }
}
