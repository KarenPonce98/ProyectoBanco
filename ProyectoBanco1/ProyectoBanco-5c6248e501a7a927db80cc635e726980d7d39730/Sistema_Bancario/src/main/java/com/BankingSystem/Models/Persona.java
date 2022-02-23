package com.BankingSystem.Models;
import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona extends Titular{
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    
    
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Persona(Long id, String nombre, String apellido) {
        //super(id, pin, no_cuenta,username,enabled);
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona() {
    }

}
