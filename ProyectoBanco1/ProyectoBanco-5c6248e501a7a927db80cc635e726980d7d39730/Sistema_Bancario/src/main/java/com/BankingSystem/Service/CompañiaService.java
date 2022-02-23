package com.BankingSystem.Service;
import com.BankingSystem.Models.Compañia;
import com.BankingSystem.Models.Titular;
import com.BankingSystem.Repository.ICompañia;
import com.BankingSystem.Repository.ITitular;
import com.BankingSystem.ServiceInterface.ICompaniaS;
import com.BankingSystem.ServiceInterface.ITitularService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.annotation.Resource;
@Service
public class CompañiaService implements ICompaniaS{
    @Autowired
    //@Resource
	private ICompañia repo;

    
	@Override
	public List<Compañia> listar() {		
		return (List<Compañia>) repo.findAll();
	}

	@Override
	public Optional<Compañia> listarId(int id) {		
		return repo.findById((long)id);
	}

	@Override
	
	public int save (Compañia p) {
		int res=0;
		Compañia ti=repo.save(p);
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
