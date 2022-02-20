package com.BankingSystem.Models;
 import javax.persistence.*;

@Entity
@Table(name="cuenta")
public class Cuenta {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int titular;
    int pin;
    int balance;
    int no_cuenta;
    int transaccion;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getTitular() {
        return titular;
    }
    public void setTitular(int titular) {
        this.titular = titular;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public int getBanco() {
        return balance;
    }
    public void setBanco(int banco) {
        this.balance = banco;
    }
    public int getNo_cuenta() {
        return no_cuenta;
    }
    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }
    public int getTransaccion() {
        return transaccion;
    }
    public void setTransaccion(int transaccion) {
        this.transaccion = transaccion;
    }
}
