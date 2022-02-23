package com.BankingSystem.Repository;

import com.BankingSystem.Models.Titular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITitular extends JpaRepository<Titular, Long>{
    
}
