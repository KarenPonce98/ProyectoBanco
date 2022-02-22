package com.BankingSystem.Models;
import javax.persistence.*;

@Entity
@Table(name="cuenta_comercial")
public class CuentaComercial extends Cuenta{
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String tipo;
    String peronas_autoriozadas;

}
