package com.BankingSystem.Repository;

import com.BankingSystem.Models.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransectionRepository extends JpaRepository<Transaction, Integer> {

}
