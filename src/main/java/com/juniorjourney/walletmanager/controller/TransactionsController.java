package com.juniorjourney.walletmanager.controller;

import com.juniorjourney.walletmanager.domain.transactions.Transactions;
import com.juniorjourney.walletmanager.domain.transactions.TransactionsRequestDTO;
import com.juniorjourney.walletmanager.service.TransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    private TransactionsService transactionsService;

    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody TransactionsRequestDTO transactionsRequestDTO) {
        Transactions transaction = transactionsService.createTransaction(transactionsRequestDTO);
        return ResponseEntity.ok(transaction);
    }

}
