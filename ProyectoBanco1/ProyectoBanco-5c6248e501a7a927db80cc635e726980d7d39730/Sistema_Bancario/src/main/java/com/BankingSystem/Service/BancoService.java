package com.BankingSystem.Service;

import com.BankingSystem.Models.Banco;
import com.BankingSystem.Repository.IBanco;
import com.BankingSystem.ServiceInterface.IBancoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class BancoService implements IBancoService{
    @Autowired
    private IBanco repo;

    
	@Override
	public List<Banco> listar() {		
		return (List<Banco>) repo.findAll();
	}

	@Override
	public Optional<Banco> listarId(int id) {		
		return repo.findById(id);
	}

	@Override
	public int save (Banco t) {
		int res=0;
		Banco ti=repo.save(t);
		if(!ti.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}
}
