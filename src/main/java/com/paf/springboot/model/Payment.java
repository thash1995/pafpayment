package com.paf.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name ="payment")
@EntityListeners(AuditingEntityListener.class)
public class Payment implements Serializable {

	private static final long serialVersionUID = 1143993377101043360L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long pid;
	private String customer_number;
	private String description;
	private String date;
	private String amount;
	private String quanty;
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getQuanty() {
		return quanty;
	}
	public void setQuanty(String quanty) {
		this.quanty = quanty;
	}
	
	
}
