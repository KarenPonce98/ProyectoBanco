package com.BankingSystem.Repository;

import java.util.Optional;

import com.BankingSystem.Models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByaccountNumber(String actNum);

}
