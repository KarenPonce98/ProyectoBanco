package com.BankingSystem.Models;
import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}