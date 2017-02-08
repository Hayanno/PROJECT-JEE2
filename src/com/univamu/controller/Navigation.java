package com.univamu.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="nav")
public class Navigation {

	public String index() {
	    return "index";
	}
	
	public String logIn() {
	    return "logIn";
	}
	
	public String signIn() {
		return "signIn";
	}
	
	public String account() {
		return "myAccount";
	}
	
	public String showCV() {
		return "showCV";
	}
	
	public String editCv() {
		return "editCV";
	}
	
	public String showPerson() {
		return "showPerson";
	}
	
	public String editPerson() {
		return "editPerson";
	}
}
