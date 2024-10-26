package com.juniorjourney.walletmanager;

import com.juniorjourney.walletmanager.domain.transactions.Action;
import com.juniorjourney.walletmanager.domain.transactions.Transactions;
import com.juniorjourney.walletmanager.domain.transactions.TransactionsRequestDTO;
import com.juniorjourney.walletmanager.domain.wallet.Wallet;
import com.juniorjourney.walletmanager.repositories.TransactionsRepository;
import com.juniorjourney.walletmanager.repositories.WalletRepository;
import com.juniorjourney.walletmanager.service.TransactionsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionsServiceTest {

    @Mock
    private WalletRepository walletRepository;

    @Mock
    private TransactionsRepository transactionsRepository;

    @InjectMocks
    private TransactionsService transactionsService;

    @Test
    public void testCreateTransactionIncrement() {
        Wallet wallet = new Wallet();
        wallet.setAmount(100);
        wallet.setUserId(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));

        TransactionsRequestDTO dto = new TransactionsRequestDTO(
                null,
                50,
                Action.INCREMENT,
                "source",
                wallet,
                new Date()
        );


        when(walletRepository.save(any(Wallet.class))).thenReturn(wallet);


        Transactions transactionMock = new Transactions(
                50,
                Action.INCREMENT,
                "source",
                wallet,
                new Date()
        );

        when(transactionsRepository.save(any(Transactions.class))).thenReturn(transactionMock);

        Transactions transaction = transactionsService.createTransaction(dto);

        assertEquals(150, wallet.getAmount());
        assertNotNull(transaction);
        assertEquals(transactionMock, transaction);
    }
}
