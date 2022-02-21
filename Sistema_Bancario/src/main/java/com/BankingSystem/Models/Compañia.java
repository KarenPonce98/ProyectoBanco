package com.BankingSystem.Models;

import javax.persistence.*;

@Entity
@Table(name="compañia")

public class Compañia extends Titular{
    

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
}
