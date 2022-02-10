package com.hcl.petShop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name" ,length=20)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)//, mappedBy = "user")
	//@JsonManagedReference
	private Pet pet;
	
	public User() {}

	public User(int id, String name, Pet pet) {
		super();
		this.id = id;
		this.name = name;
		this.pet = pet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pet=" + pet + "]";
	}


	
	
	
	
	

}
