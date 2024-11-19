package com.nathan.agregadorinvestimentos.service;

import com.nathan.agregadorinvestimentos.dto.CreateStockDto;
import com.nathan.agregadorinvestimentos.entity.Stock;
import com.nathan.agregadorinvestimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public void createStock(CreateStockDto createStockDto) {

        var stock = new Stock(
                createStockDto.stockId(),
                createStockDto.description()
        );

        stockRepository.save(stock);
    }
}
