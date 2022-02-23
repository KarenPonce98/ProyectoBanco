package com.BankingSystem.Models;
import javax.persistence.*;

@Entity
@Table(name="titular")
public class Titular {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int pin;
    private int no_cuenta;
    private String username;
    private char enabled;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getPin() {
        return pin;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public char getEnabled() {
        return enabled;
    }
    public void setEnabled(char enabled) {
        this.enabled = enabled;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public int getNo_cuenta() {
        return no_cuenta;
    }
    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }
    public Titular() {
    }
    public Titular(Long id, int pin, int no_cuenta, String username,char enabled) {
        this.id = id;
        this.pin = pin;
        this.no_cuenta = no_cuenta;
        this.username=username;
        this.enabled=enabled;
    }


}
