package com.BankingSystem.Models;
 import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable {
    private static final long serialVersionUID=1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cuenta;
    private int titular;//TRAER NOMBRE DE TITULAR
    private int pin;
    private double balance;//
    //private int no_cuenta; PARA EL NOCUENTA SOLO SE GUARDARA EL ID DEL TITULAR Y EN EL HTML SE MOSTRARA
   // private int banco;

    @ManyToOne
    private Banco banco;
    public Long getId_cuenta() {
        return id_cuenta;
    }
    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
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
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    /*public int getBanco() {
        return banco;
    }
    public void setBanco(int banco) {
        this.banco = banco;
    }*/
    public Cuenta() {
    }
    public Cuenta(Long id_cuenta, int titular, int pin, double balance) {
        super();
        this.id_cuenta = id_cuenta;
        this.titular = titular;
        this.pin = pin;
        this.balance = balance;
    }

}
