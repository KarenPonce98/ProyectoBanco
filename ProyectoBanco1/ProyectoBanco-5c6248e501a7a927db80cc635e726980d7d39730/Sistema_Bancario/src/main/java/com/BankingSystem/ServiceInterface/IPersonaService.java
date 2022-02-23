package com.BankingSystem.ServiceInterface;

import com.BankingSystem.Models.Persona;
import com.BankingSystem.Models.Titular;

import java.util.*;

public interface IPersonaService{
    public List<Persona> listar();

	public Optional<Persona> listarId(int id);

	public int save(Persona p);

	public void delete(int id);
}
