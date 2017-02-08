package com.univamu.model;

import javax.persistence.Embeddable;

@Embeddable
public class Activity {
	private String year;
	private String nature;
	private String title;
	private String description;
	private String website;
	
	/* ---- Constructor ---- */
	public Activity() {}
	
	/* ------ Getters ------ */
	public String 	getYear() 			{ return year; 			}
	public String 	getNature() 		{ return nature; 		}
	public String 	getTitle() 			{ return title; 		}
	public String 	getDescription() 	{ return description; 	}
	public String 	getWebsite() 		{ return website;		}

	/* ------ Setters ------ */
	public void setYear(String year) 				{ this.year = year; 				}
	public void setNature(String nature) 			{ this.nature = nature; 			}
	public void setTitle(String title) 				{ this.title = title; 				}
	public void setDescription(String description) 	{ this.description = description; 	}
	public void setWebsite(String website) 			{ this.website = website; 			}

	@Override
	public String toString(){
		return 	"Title : " + this.title +
				"\nNature : " + this.nature +
				"\nYear : " + this.year +
				"\nWebsite : " + this.website;
	}
}
