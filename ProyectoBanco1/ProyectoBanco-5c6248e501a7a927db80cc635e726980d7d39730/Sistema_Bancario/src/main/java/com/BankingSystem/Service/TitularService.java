package com.BankingSystem.Service;

import com.BankingSystem.Models.Titular;
import com.BankingSystem.Repository.ITitular;
import com.BankingSystem.ServiceInterface.ITitularService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class TitularService implements ITitularService{
    @Autowired
    private ITitular repo;

    
	@Override
	public List<Titular> listar() {		
		return (List<Titular>) repo.findAll();
	}

	@Override
	public Optional<Titular> listarId(int id) {		
		return repo.findById((long)id);
	}

	@Override
	public int save (Titular t) {
		int res=0;
		Titular ti=repo.save(t);
		if(!ti.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		repo.deleteById((long) id);
		
	}
}
