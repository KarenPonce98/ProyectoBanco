package com.BankingSystem.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.BankingSystem.Models.Titular;

public interface ITitularService{
    public List<Titular> listar();

	public Optional<Titular> listarId(int id);

	public int save(Titular t);

	public void delete(int id);
}
