package com.BankingSystem.service;
//import TiendaOnline.VentadeHuevos.entity.User;

import com.BankingSystem.dto.*;
import com.BankingSystem.Models.*;

/**
 *
 * @author Luiis
 */
public interface UserService {
    public Iterable <User1> getAllUsers();

    public User1 createUser(User1 user) throws Exception;
    
    public User1 getUserById(Long id) throws Exception;
    
    public User1 updateUser(User1 user)  throws Exception;
    
    public void deleteUser(Long id) throws Exception;
    
    public User1 changePassword(ChangePassword form) throws Exception;
}
