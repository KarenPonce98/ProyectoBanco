package com.BankingSystem.Service;
import com.BankingSystem.Models.Persona;
import com.BankingSystem.Repository.IPersona;
import com.BankingSystem.ServiceInterface.IPersonaS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class PersonaService implements IPersonaS {

    @Autowired
	private IPersona repo;

    
	@Override
	public List<Persona> listar() {		
		return (List<Persona>) repo.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {		
		return repo.findById((long)id);
	}

	@Override
	public int save (Persona p) {
		int res=0;
		Persona ti=repo.save(p);
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
