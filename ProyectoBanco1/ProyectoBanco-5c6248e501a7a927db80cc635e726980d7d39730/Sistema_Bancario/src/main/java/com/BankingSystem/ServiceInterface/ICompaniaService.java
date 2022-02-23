package com.BankingSystem.ServiceInterface;

import com.BankingSystem.Models.Compañia;
import java.util.*;

public interface ICompaniaService {
    public List<Compañia> listar();

	public Optional<Compañia> listarId(int id);

	public int save(Compañia c);

	public void delete(int id);
}
