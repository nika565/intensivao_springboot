package com.nathan.agregadorinvestimentos.service;

import com.nathan.agregadorinvestimentos.dto.AccountStockDto;
import com.nathan.agregadorinvestimentos.dto.AccountStockResponseDto;
import com.nathan.agregadorinvestimentos.entity.AccountStock;
import com.nathan.agregadorinvestimentos.entity.AccountStockId;
import com.nathan.agregadorinvestimentos.repository.AccountRepository;
import com.nathan.agregadorinvestimentos.repository.AccountStockRepository;
import com.nathan.agregadorinvestimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountStockRepository accountStockRepository;


    public void associateStock(String accountId, AccountStockDto accountStockDto) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account nao existe"));

        var stock = stockRepository.findById(accountStockDto.stockId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock nao existe"));

        var id = new AccountStockId(account.getAccountId(), stock.getStockId());

        var accountStockEntity = new AccountStock(id, account, stock, accountStockDto.quantity());

        accountStockRepository.save(accountStockEntity);
    }

    public List<AccountStockResponseDto> listStocks(String accountId) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account nao existe"));

        return account.getAccountStocks()
                .stream()
                .map(ac -> new AccountStockResponseDto(ac.getStock().getStockId(), ac.getQuantity(), 0.0))
                .toList();

    }
}
