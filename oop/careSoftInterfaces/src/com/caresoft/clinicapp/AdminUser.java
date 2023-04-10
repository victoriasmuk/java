package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public AdminUser(Integer id, String role) {
    	super(id);
    	this.role = role;
    }
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	@Override
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() < 6) {
			System.out.println("Pin must be 6 or more digits! ");
			return false;
		}
		this.pin = pin;
		return true;
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == this.id) {
			return true;
		}
		authIncident();
		return false;
	}
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return securityIncidents;
	}
	public void newIncident(String notes) {
		String report = String.format(
				"Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
				new Date(), this.id, notes
				);
		securityIncidents.add(report);
	}
	public void authIncident() {
		String report = String.format(
				"Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
				new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
				);
		securityIncidents.add(report);
	}
}