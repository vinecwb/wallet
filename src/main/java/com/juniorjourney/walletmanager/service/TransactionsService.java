package com.juniorjourney.walletmanager.service;

import com.juniorjourney.walletmanager.domain.transactions.Transactions;
import com.juniorjourney.walletmanager.domain.transactions.TransactionsRequestDTO;
import com.juniorjourney.walletmanager.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionsService {
    private final TransactionsRepository transactionsRepository;

    @Autowired
    public TransactionsService(TransactionsRepository transactionRepository) {
        this.transactionsRepository = transactionRepository;
    }

    public Transactions createTransaction(TransactionsRequestDTO transactionsRequestDTO) {
        Transactions transaction = new Transactions();
        transaction.setAmount(transactionsRequestDTO.amount());
        transaction.setAction(transactionsRequestDTO.action());
        transaction.setSource(transactionsRequestDTO.source());
        transaction.setWallet(transactionsRequestDTO.wallet());
        transaction.setCreatedAt(new Date());

        return transactionsRepository.save(transaction);

    }
}
