package com.univamu.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person{
	
	@Id
	private String 	email;
	
	private String 	lastname;
	private String 	firstname;
	private String 	website;
	private String 	password;
	
	@Temporal(TemporalType.DATE)
	private Date	birthdate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cv cv;
	
	/* ---- Constructor ---- */
	public Person() {}
	
	/* ------ Getters ------ */
	public String 	getLastname() 	{ return lastname; 	}
	public String 	getFirstname() 	{ return firstname; }
	public String 	getEmail() 		{ return email; 	}
	public String 	getWebsite() 	{ return website; 	}
	public Date 	getBirthdate() 	{ return birthdate; }
	public String 	getPassword() 	{ return password; 	}
	public Cv		getCv()			{ return cv;		}
	
	/* ------ Setters ------ */
	public void setLastname(String lastname) 	{ this.lastname = lastname; 	}
	public void setFirstname(String firstname) 	{ this.firstname = firstname; 	}
	public void setEmail(String email) 			{ this.email = email; 			}
	public void setWebsite(String website) 		{ this.website = website; 		}
	public void setBirthdate(Date birthdate) 	{ this.birthdate = birthdate; 	}
	public void setPassword(String password) 	{ this.password = password; 	}
	public void setCv(Cv cv) 					{ this.cv = cv;					}
	
	@Override
	public String toString() {
		return	"*Person* : Firstname : " + this.firstname +
				"\nLastname : " + this.lastname +
				"\nEmail : " + this.email +
				"\nBirthdate : " + this.birthdate +
				"\nWebsite : " + this.website;
	}
	
}
