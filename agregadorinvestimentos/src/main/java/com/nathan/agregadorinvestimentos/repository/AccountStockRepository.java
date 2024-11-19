package com.nathan.agregadorinvestimentos.repository;

import com.nathan.agregadorinvestimentos.entity.AccountStock;
import com.nathan.agregadorinvestimentos.entity.AccountStockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockId> {
}
