package com.nathan.picpay.service;

import com.nathan.picpay.dto.CreateWalletDto;
import com.nathan.picpay.entity.Wallet;
import com.nathan.picpay.exception.WalletDataAlreadyExistsException;
import com.nathan.picpay.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    public Wallet createWallet(CreateWalletDto dto) {
        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if(walletDb.isPresent()){
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }
;       return walletRepository.save(dto.toWallet());
    }

}
