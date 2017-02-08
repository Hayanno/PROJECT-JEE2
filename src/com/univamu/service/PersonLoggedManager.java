package com.univamu.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import com.univamu.model.Person;

@Stateful
public class PersonLoggedManager {
	
	private Person p = null;
	
	@EJB
	private AuthenticationManager authManager;
	
	@PostConstruct 
	public void init(){
		System.out.println("AuthManager initialized.");
	}
	
	@Remove
	public void close() {
		System.out.println(this.p.getFirstname() + " " + this.p.getLastname() + " deconnected.");
	}
	
	public Person getUser() { 
		return this.p; 
	}
	
	public Person login(String login, String password) {
		this.p = authManager.login(login, password);
		
		return this.p;
	}
	
	public void logout() {
		this.p = null;
	}
}
