package com.juniorjourney.walletmanager.service;

import com.juniorjourney.walletmanager.domain.transactions.Action;
import com.juniorjourney.walletmanager.domain.transactions.Transactions;
import com.juniorjourney.walletmanager.domain.transactions.TransactionsRequestDTO;
import com.juniorjourney.walletmanager.domain.transactions.TransactionsResponseDTO;
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
    public TransactionsResponseDTO createTransaction(TransactionsRequestDTO transactionsRequestDTO) {
        Wallet wallet = walletRepository.findById(transactionsRequestDTO.walletId())
                .orElseThrow(() -> new IllegalArgumentException("Carteira não encontrada"));

        if (transactionsRequestDTO.action() == Action.INCREMENT) {
            wallet.setAmount(wallet.getAmount() + transactionsRequestDTO.amount());
        } else if (transactionsRequestDTO.action() == Action.DECREMENT) {
            if (wallet.getAmount() >= transactionsRequestDTO.amount()) {
                wallet.setAmount(wallet.getAmount() - transactionsRequestDTO.amount());
            } else {
                throw new IllegalArgumentException("Saldo insuficiente na carteira");
            }
        }

        walletRepository.save(wallet);

        if (wallet.getUserId() == null) {
            throw new IllegalArgumentException("userId não pode ser nulo");
        }

        Transactions transaction = new Transactions();
        transaction.setAmount(transactionsRequestDTO.amount());
        transaction.setAction(transactionsRequestDTO.action());
        transaction.setSource(transactionsRequestDTO.source());
        transaction.setWallet(wallet);
        transaction.setCreatedAt(new Date());


        Transactions savedTransaction = transactionsRepository.save(transaction);


        return new TransactionsResponseDTO(
                savedTransaction.getId(),
                savedTransaction.getAmount(),
                savedTransaction.getAction(),
                savedTransaction.getSource(),
                savedTransaction.getWallet().getId(),
                savedTransaction.getCreatedAt()
        );
    }
}
