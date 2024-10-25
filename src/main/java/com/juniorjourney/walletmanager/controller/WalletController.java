package com.juniorjourney.walletmanager.controller;

import com.juniorjourney.walletmanager.domain.wallet.Wallet;
import com.juniorjourney.walletmanager.domain.wallet.WalletRequestDTO;
import com.juniorjourney.walletmanager.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Wallet> create(@RequestBody WalletRequestDTO body){
        Wallet newWallet = this.walletService.createWallet(body);
        return ResponseEntity.ok(newWallet);
    }
}
