package com.BankingSystem.Models;
import javax.persistence.*;

@Entity
@Table(name="cuenta_consumidor")
public class CuentaConsumidor {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String tipo;

}
