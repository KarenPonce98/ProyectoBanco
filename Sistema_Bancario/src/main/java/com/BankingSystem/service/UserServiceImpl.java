package com.BankingSystem.service;

import com.BankingSystem.dto.*;
import com.BankingSystem.Models.*;
import com.BankingSystem.Repository.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luiis
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository1 repository;

    @Override
    public Iterable getAllUsers() {
        return repository.findAll();
    }

    private boolean checkUsernameAvailable(User1 user) throws Exception {
        Optional<User1> userFound = repository.findByUsername(user.getUsername());

        if (userFound.isPresent()) {
            throw new Exception("Username no disponible.");

        }
        return true;
    }

    private boolean checkPasswordValid(User1 user) throws Exception {
        if(user.getConfirmpassword()== null || user.getConfirmpassword().isEmpty()){
           throw new Exception("Confirm Password es obligatorio");
        }
        if (!user.getPassword().equals(user.getConfirmpassword())) {
            throw new Exception("Password y Confirm Password no son iguales");
        }
        return true;
    }

    @Override
    public User1 createUser(User1 user) throws Exception{
        if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
            user = repository.save(user);
        }
        return user;
    }
    
    @Override
    public User1 getUserById(Long id) throws Exception{
        return repository.findById(id).orElseThrow(()-> new Exception("El Usuario no existe"));
    }
    
    @Override
    public User1 updateUser(User1 fromUser) throws Exception{
     User1 toUser = getUserById(fromUser.getId());
     mapUser (fromUser, toUser);
     return repository.save(toUser); 
    }
    
    //Hacer el mappeo, fro es de donde y to a donde
    protected void mapUser(User1 from,User1 to) {
		to.setUsername(from.getUsername());
		to.setFirstname(from.getFirstname());
		to.setLastname(from.getLastname());
		to.setEmail(from.getEmail());
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User1 user = getUserById(id);
        
        repository.delete(user);
    }

    @Override
    public User1 changePassword(ChangePassword form) throws Exception {
    
    User1 user = getUserById(form.getId());
    
    if(!user.getPassword().equals(form.getCurrentPassword())){
        throw new Exception ("La Contraseña no  es Invalida");
    }
    
    if(user.getPassword().equals(form.getNewPassword())){
        throw new Exception ("La contraseña nueva debe de ser diferente a la contraseña actual.");
    }
    
    if(!form.getNewPassword().equals(form.getConfirmPassword())){
       throw new Exception ("Las contraseñas no coinciden. Intentalo de nuevo.");
    }
    
    user.setPassword(form.getNewPassword());
    return repository.save(user);
            
     
    }

}
