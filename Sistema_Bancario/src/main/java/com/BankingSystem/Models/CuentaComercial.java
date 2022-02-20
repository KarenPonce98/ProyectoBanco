package com.BankingSystem.Models;
import javax.persistence.*;

@Entity
@Table(name="cuenta_comercial")
public class CuentaComercial extends Cuenta{
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    String tipo;
    String peronas_autoriozadas;

}
