package com.nathan.picpay.service;

import com.nathan.picpay.dto.TransferDto;
import com.nathan.picpay.entity.Transfer;
import com.nathan.picpay.entity.Wallet;
import com.nathan.picpay.exception.TransferNotAllowedForWalletTypeException;
import com.nathan.picpay.exception.WalletNotFoundException;
import com.nathan.picpay.repository.TransferRepository;
import com.nathan.picpay.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private WalletRepository walletRepository;

    public Transfer transfer(TransferDto dto) {
        var sender = walletRepository.findById(dto.payer())
                .orElseThrow(() -> new WalletNotFoundException(dto.payer()));

        var receiver = walletRepository.findById(dto.payee())
                .orElseThrow(() -> new WalletNotFoundException(dto.payee()));


        return null;
    }

    private void validateTransfer(TransferDto transferDto, Wallet sender){
        if(!sender.isTransferAllowedForWalletType()){
            throw new TransferNotAllowedForWalletTypeException();
        }

        if(!sender.isBalancerEqualOrGreaterThan(transferDto.value())) {
            throw new InsufficientBalanceException(transferDto.value());
        }
    }
}
