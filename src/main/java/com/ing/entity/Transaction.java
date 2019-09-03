package com.ing.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> 5f122cd1f7308483514ab46fed852ada053d9321

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private LocalDateTime transactionDate;
<<<<<<< HEAD
=======

>>>>>>> 5f122cd1f7308483514ab46fed852ada053d9321
	private double transactionAmount;
	private String description;
	private String accountNumber;
	private String accountType;
	private String transactionType;
	private double transactionBalance;
	private double mortagageBalance;

}
