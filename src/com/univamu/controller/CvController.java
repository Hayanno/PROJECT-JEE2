package com.univamu.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.univamu.model.Cv;
import com.univamu.service.CvManager;

@ManagedBean
@SessionScoped
public class CvController {
	
	private Cv cv = new Cv();
	private Navigation nav = new Navigation();
	
	@EJB
	private CvManager cm;
	
	public Cv getCv() {
		return this.cv;
	}
	
	public List<Cv> findAll() {
		return cm.findAll();
	}
	
	public void store() {
		cm.create(cv);
	}
	
	public void update() {
		cm.update(cv);
	}
	
	public void remove() {
		cm.remove(cv.getId());
	}
	
	public String show(Long id) {
		cv = cm.find(id);
		
		return nav.showCV();
	}
	
	public String edit() {
		return nav.editCv();
	}	
}