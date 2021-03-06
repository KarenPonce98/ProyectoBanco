package com.BankingSystem.Models;

import javax.persistence.*;

@Entity
@Table(name="compania")

public class Compañia extends Titular{
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String nombre;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Compañia() {
       
    }
    public Compañia(Long id, int pin, int no_cuenta,String username,char enabled, Long id2, String nombre) {
        super(id, pin, no_cuenta,username,enabled);
        id = id2;
        this.nombre = nombre;
    }

    
}
