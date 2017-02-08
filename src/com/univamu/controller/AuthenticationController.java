package com.univamu.controller;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import com.univamu.model.Person;
import com.univamu.service.PersonLoggedManager;

@ManagedBean
@SessionScoped
public class AuthenticationController {

	@EJB
	private PersonLoggedManager plm;
	
	private Navigation nav = new Navigation();
	
	public String login(String email, String pwd) {
		Person person = plm.login(email, pwd);
		
		if (person == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			
			context.addMessage(null, new FacesMessage("Unknown login, try again"));
			
			return null;
		}
		
		return nav.account();
	}

	public String logout() {
		plm.logout();
		return nav.logIn();
	}

	public boolean isConnected() {
		return plm.getUser() != null;
	}
	
	public Person getConnectedUser() {
		return plm.getUser();
	}


	public void redirectToAuth(ComponentSystemEvent event) {
		if(!isConnected()) {
			FacesContext fc = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler cNav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();

			cNav.performNavigation(nav.logIn() + ".xhtml");
		}
	}

}
