package com.BankingSystem.Repository;

import java.util.Optional;
import com.BankingSystem.Models.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBanco extends JpaRepository<Banco, Integer> {
    
}
