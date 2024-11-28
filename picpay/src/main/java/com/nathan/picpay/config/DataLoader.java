package com.nathan.picpay.config;

import com.nathan.picpay.entity.WalletType;
import com.nathan.picpay.repository.WalletRepository;
import com.nathan.picpay.repository.WalletTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletTypeRepository walletTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values())
                .forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
