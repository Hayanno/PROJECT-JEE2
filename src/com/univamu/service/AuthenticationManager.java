package com.univamu.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.univamu.model.Person;

@Stateless(name = "authManager")
public class AuthenticationManager {
	
	@PersistenceContext(unitName = "jdbcMySQLBase")
	private EntityManager em;

	public Person login(String email, String pwd) {
		Person p = em.find(Person.class, email);
        
		if(p != null && p.getPassword().equals(pwd))
			return p;
		
		return null;
	}
}

