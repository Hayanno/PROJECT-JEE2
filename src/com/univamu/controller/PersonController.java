package com.univamu.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.univamu.model.Person;
import com.univamu.service.PersonManager;

@ManagedBean
@SessionScoped
public class PersonController {

	private Person p = new Person();
	private Navigation nav = new Navigation();

	@EJB
	private PersonManager pm;

	public Person getPerson() {
		return this.p;
	}

	public List<Person> findAll() {
		return pm.findAll();
	}

	public String storePerson() {
		try {
			pm.save(p);
		} catch (Exception e) {
			e.printStackTrace();
			
			return nav.index();
		}
		
		return nav.logIn();
	}

	public void updatePerson(){
		pm.update(p);
	}

	public String show(Person p) {
		this.p = pm.find(p.getEmail());
		
		return nav.showPerson();
	}

	public String edit() {
		return nav.editPerson();
	}

}