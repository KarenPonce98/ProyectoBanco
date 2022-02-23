package com.BankingSystem.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.BankingSystem.Models.Compañia;
public interface ICompaniaS {
    public List<Compañia> listar();

	public Optional<Compañia> listarId(int id);

	public int save(Compañia t);

	public void delete(int id);
}
