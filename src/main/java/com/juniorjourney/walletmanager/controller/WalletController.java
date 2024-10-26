package com.juniorjourney.walletmanager.controller;

import com.juniorjourney.walletmanager.domain.wallet.Wallet;
import com.juniorjourney.walletmanager.domain.wallet.WalletRequestDTO;
import com.juniorjourney.walletmanager.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Wallet> create(@RequestBody WalletRequestDTO body){
        Wallet newWallet = this.walletService.createWallet(body);
        return ResponseEntity.ok(newWallet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable UUID id) {
        return walletService.getWalletById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
