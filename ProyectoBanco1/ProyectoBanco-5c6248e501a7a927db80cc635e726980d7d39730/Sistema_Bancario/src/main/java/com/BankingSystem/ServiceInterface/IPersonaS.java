package com.BankingSystem.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.BankingSystem.Models.Persona;
public interface IPersonaS {
    public List<Persona> listar();

	public Optional<Persona> listarId(int id);

	public int save(Persona c);

	public void delete(int id);
}
