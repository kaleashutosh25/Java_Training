package com.hcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	
	
	@Id
	@Column(name="id")
	private int id ;
	
	@Column(name="name")
	private String Name ;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + "]";
	}
	
	
	
	
	

}
