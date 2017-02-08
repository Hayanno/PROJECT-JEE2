package com.univamu.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.univamu.model.Cv;

@Stateful
public class CvManager {
	
	@EJB
	private PersonLoggedManager plm;

	@PersistenceContext(unitName = "jdbcMySQLBase")
	private EntityManager em;

	@PostConstruct
	public void init() {
	}

	@Remove
	public void close() {
	}

	@AroundInvoke
	public Object interceptor(InvocationContext context) throws Exception {
		Object obj = null;
		
		if(plm.getUser() != null)
			obj = context.proceed();
		
		return obj;
	}

	public void create(Cv cv) {
		em.persist(cv);
	}

	public void update(Cv cv) {
		em.merge(cv);
	}

	public Cv find(Long id) {
		return em.find(Cv.class, id);
	}

	public List<Cv> findAll() {
		//http://stackoverflow.com/questions/24572092/using-java-generics-for-jpa-findall-query-with-where-clause
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cv> cq = cb.createQuery(Cv.class);
        Root<Cv> rootEntry = cq.from(Cv.class);
        CriteriaQuery<Cv> all = cq.select(rootEntry);
        TypedQuery<Cv> allQuery = em.createQuery(all);
        
        return allQuery.getResultList();
	}

	public boolean remove(Long id) {
		Cv cv = em.find(Cv.class, id);
		
		if(cv != null) {
			em.remove(cv);
			
			return true;
		}
		
		return false;
	}//remove()
}
