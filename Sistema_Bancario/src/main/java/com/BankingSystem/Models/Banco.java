package com.BankingSystem.Models;
import javax.persistence.*;

@Entity
@Table(name="banco")
public class Banco {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

    private int cuenta;
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int getCuenta() {
        return cuenta;
    }
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getTipo_cargo() {
        return tipo_cargo;
    }
    public void setTipo_cargo(String tipo_cargo) {
        this.tipo_cargo = tipo_cargo;
    }
    private double balance;
    private String tipo_cargo;
}
