package com.hcl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hcl.entity.User;

public class Main {

	public static void main(String[] args) {
	
	EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("jpa-training");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	User user=entityManager.find( User.class,1);
	System.out.println(user);

	}

}
