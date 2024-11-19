package com.nathan.agregadorinvestimentos.controller;

import com.nathan.agregadorinvestimentos.dto.AccountStockDto;
import com.nathan.agregadorinvestimentos.dto.AccountStockResponseDto;
import com.nathan.agregadorinvestimentos.entity.User;
import com.nathan.agregadorinvestimentos.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountId}/stocks")
    public ResponseEntity<User> associateStock(@PathVariable("accountId") String accountId,
                                               @RequestBody AccountStockDto accountStockDto) {

        accountService.associateStock(accountId, accountStockDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}/stocks")
    public ResponseEntity<List<AccountStockResponseDto>> associateStock(@PathVariable("accountId") String accountId) {

        var stocks = accountService.listStocks(accountId);

        return ResponseEntity.ok(stocks);
    }
}
