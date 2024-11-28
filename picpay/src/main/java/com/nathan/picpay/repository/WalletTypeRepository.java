package com.nathan.picpay.repository;

import com.nathan.picpay.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
