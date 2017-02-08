package com.univamu.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.univamu.model.Person;

@Stateful(name = "personManager") 
public class PersonManager {

	@EJB
	private PersonLoggedManager um;

	@PersistenceContext(unitName = "jdbcMySQLBase")
	private EntityManager em;

	@PostConstruct
	public void init() {
	}

	@Remove
	public void close() {
	}

	public void save(Person p) {
		em.persist(p);
	}
	
	public void update(Person p) {
		em.merge(p);
	}

	public Person find(String email) {
		return em.find(Person.class, email);
	}

	public List<Person> findAll() {
		//http://stackoverflow.com/questions/24572092/using-java-generics-for-jpa-findall-query-with-where-clause
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> rootEntry = cq.from(Person.class);
        CriteriaQuery<Person> all = cq.select(rootEntry);
        TypedQuery<Person> allQuery = em.createQuery(all);
        
        return allQuery.getResultList();
	}

	public boolean remove(String email) {
		Person person = em.find(Person.class, email);
		
		if(person != null) {
			em.remove(person);
			
			return true;
		}
		
		return false;
	}

}