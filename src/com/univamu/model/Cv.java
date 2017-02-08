package com.univamu.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cv {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToOne(mappedBy="cv")
	private Person person;
	
	@ElementCollection
	public List<Activity> activities;
	
	/* ---- Constructor ---- */
	public Cv() {}
	
	/* ------ Getters ------ */
	public Long 			getId() 				{ return id;							}
	public String			getName()				{ return name;							}
	public Person			getPerson()				{ return person;						}
	public List<Activity> 	getActivities() 		{ return activities;					}
	public Activity			getActivity(int index)	{ return this.activities.get(index); 	}

	/* ------ Setters ------ */
	public void setId(Long id) 								{ this.id = id; 					}
	public void setName(String name)						{ this.name = name;					}
	public void setPerson(Person person) 					{ this.person = person;				}
	public void setActivities(List<Activity> activities) 	{ this.activities = activities;		}
	public void addActivity(Activity activity) 				{ this.activities.add(activity);	}
	public void removeActivity(Activity activity) 			{ this.activities.remove(activity);	}
	
	@Override
	public String toString(){
		return 	"Id : " + this.id +
				"\nName : " + this.name +
				"\nActivites : " + this.activities;
	}
}
