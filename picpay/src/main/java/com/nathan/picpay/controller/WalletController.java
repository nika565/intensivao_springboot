package com.nathan.picpay.controller;

import com.nathan.picpay.dto.CreateWalletDto;
import com.nathan.picpay.entity.Wallet;
import com.nathan.picpay.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto dto) {
        Wallet wallet = walletService.createWallet(dto);
        return ResponseEntity.ok(wallet);
    }

}
