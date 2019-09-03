package com.ing.entity;

import java.io.Serializable;

import javax.persistence.Entity;
<<<<<<< HEAD

=======
>>>>>>> 9aa6efcc57280d9c1006b81e5295cd11b657cc42
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mortagage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
<<<<<<< HEAD
	
=======
>>>>>>> 9aa6efcc57280d9c1006b81e5295cd11b657cc42
	private String mortagageId;
	private String mortagageType;
	private double propertyCost;
	private double deposit;
	private String customerId;
	private double mortagageBalance;

}
