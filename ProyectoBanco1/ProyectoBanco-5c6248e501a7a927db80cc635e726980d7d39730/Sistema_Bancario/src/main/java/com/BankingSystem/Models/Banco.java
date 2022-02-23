package com.BankingSystem.Models;
import javax.persistence.*;

@Entity
@Table(name="banco")
public class Banco {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    private String cuenta;
    private double balance;
    private String tipo_cargo;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        id = id;
    }
    public String getCuenta() {
        return cuenta;
    }
    public void setCuenta(String cuenta) {
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
    
}
