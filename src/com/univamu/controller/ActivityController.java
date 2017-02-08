package com.univamu.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.univamu.model.Activity;

@ManagedBean
@ViewScoped
public class ActivityController {

	@ManagedProperty("#{cv}")
	private CvController cvC;
	
	private Activity activity = new Activity(); 
	
	public Activity getActivity() {
		return activity;
	}
	
	public Activity getActivity(int index) {
		activity = getActivities().get(index);
		
		return activity;
	}
	
	public List<Activity> getActivities() {
		return cvC.getCv().getActivities();
	}
	
	public void storeActivity() {
		getActivities().add(activity);
	}	
}