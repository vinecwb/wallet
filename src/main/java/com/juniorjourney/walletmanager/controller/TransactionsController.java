package com.juniorjourney.walletmanager.controller;


import com.juniorjourney.walletmanager.domain.transactions.TransactionsRequestDTO;
import com.juniorjourney.walletmanager.domain.transactions.TransactionsResponseDTO;
import com.juniorjourney.walletmanager.service.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    private final TransactionsService transactionsService;

    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping
    public ResponseEntity<TransactionsResponseDTO> createTransaction(@RequestBody TransactionsRequestDTO requestDTO) {
        TransactionsResponseDTO responseDTO = transactionsService.createTransaction(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
