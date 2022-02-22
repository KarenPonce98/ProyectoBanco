package com.BankingSystem.Models;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="banco")
public class Banco {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_banco;
    private String tipo_cargo;
    
   // @OneToMany (mappedBy = "banco")
    //private List<Cuenta>cuentas;
    //@JoinTable(name = "banco_cuenta",
      //      joinColumns=@JoinColumn(name="id_banco"),
        //    inverseJoinColumns=@JoinColumn(name="id_cuenta"))
    

    private int cuenta;//SE TRAE DE CUENTA 
    //private double balance;

    public int getId() {
        return id_banco;
    }
    public void setId(int id) {
        this.id_banco = id;
    }
    
   /* public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }*/
    public String getTipo_cargo() {
        return tipo_cargo;
    }
    public void setTipo_cargo(String tipo_cargo) {
        this.tipo_cargo = tipo_cargo;
    }
    public Banco(int id_banco, String tipo_cargo) {
        super();
        this.id_banco = id_banco;
        this.tipo_cargo = tipo_cargo;
    }
    public Banco() {
    }
}
