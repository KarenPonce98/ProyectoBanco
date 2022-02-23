package com.BankingSystem.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.BankingSystem.Models.Banco;

public interface IBancoService {
    public List<Banco> listar();

	public Optional<Banco> listarId(int id);

	public int save(Banco t);

	public void delete(int id);
}
