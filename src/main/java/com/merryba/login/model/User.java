package com.merryba.login.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user")

public class User {
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.AUTO)
	 	@Column(name = "id")
	 	private int id;
	 	
	 	@Column(name = "email", nullable = false, unique = true)
	 	@Email(message = "Please provide a valid e-mail")
	 	@NotEmpty(message = "Please provide an e-mail")
	 	private String email;
	 	
	 	@Column(name = "password")
	 	private String password;
	 	
	 	

	 	public int getId() {
	 		return id;
	 	}

	 	public void setId(int id) {
	 		this.id = id;
	 	}

	 	public String getPassword() {
	 		return password;
	 	}

	 	public void setPassword(String password) {
	 		this.password = password;
	 	}

	 	

	 	public String getEmail() {
	 		return email;
	 	}

	 	public void setEmail(String email) {
	 		this.email = email;
	 	}

	 	
	 }
