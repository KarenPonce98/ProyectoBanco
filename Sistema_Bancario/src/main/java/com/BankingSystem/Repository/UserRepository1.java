package com.BankingSystem.Repository;

import com.BankingSystem.Models.*;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luiis
 */
@Repository
public interface UserRepository1 extends CrudRepository<User1, Long> {

 public Optional <User1> findByUsername(String username); 
}
