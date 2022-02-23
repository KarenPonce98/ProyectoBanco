package com.BankingSystem.Repository;

import com.BankingSystem.Models.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IPersona extends JpaRepository<Persona, Long>{

}
