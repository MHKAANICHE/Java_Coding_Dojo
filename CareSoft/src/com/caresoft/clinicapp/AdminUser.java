package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminUser extends User implements HIPAAComplantUser, HIPAACompliantAdmin {

	// Inside class:
	private String role;
	private ArrayList<String> securityIncidents;

	// Full args constructor
	// constructor that takes an ID and a role
	public AdminUser(Integer id) {
		super(id);
	}

	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
	}

	// Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		if (pin < 99999 || pin>999999) {
			this.id = pin;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID.equals(id)) {
			return true;
		} else {
			return false;
		}
	}

	// Implement HIPAACompliantAdmin!
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		ArrayList<String> reportSecurityIncidents = new ArrayList<String>();

		return reportSecurityIncidents;
	}

	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(),
				this.id, notes);
		securityIncidents.add(report);
	}

	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.id,
				"AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}

	// Getters and Setters
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

}
