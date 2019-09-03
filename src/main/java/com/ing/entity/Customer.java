package com.ing.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
<<<<<<< HEAD

=======
>>>>>>> 9aa6efcc57280d9c1006b81e5295cd11b657cc42
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
<<<<<<< HEAD

=======
>>>>>>> 9aa6efcc57280d9c1006b81e5295cd11b657cc42
	private String customerId;
	private String email;
	private String firstName;
	private String lastName;
	private String occupation;
	private String mobile;
	private String password;
	private LocalDate dob;

}
