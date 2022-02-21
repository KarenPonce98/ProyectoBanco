package com.BankingSystem.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaccion")
public class Transaction {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
       private int id;
	   private int banco_nombre;//PARA HACER LA RELACION CON BANCO Y SACAR EL NOMBRE DEL BANCO
	   private String cargo;// Y EL RIPO DE CARGO..

       private double amount;//MONTO DE LA TRANSSACCION

       private String sendBy;//cuenta_remitente

       private String sendTo;//cuenta_destinatario

       @Temporal(TemporalType.TIMESTAMP)//OBTENER FECHA DE LA TRANSACCION
       private Date sendOn;//fecha

       private String status;//estado
     //Getters and Setters  
       
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double ammount) {
		this.amount = ammount;
	}
	public String getSendBy() {
		return sendBy;
	}
	public void setSendBy(String sendBy) {
		this.sendBy = sendBy;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public Date getSendOn() {
		return sendOn;
	}
	public void setSendOn(Date sendOn) {
		this.sendOn = sendOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBanco_nombre() {
		return banco_nombre;
	}
	public void setBanco_nombre(int banco_nombre) {
		this.banco_nombre = banco_nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
       
       
}
