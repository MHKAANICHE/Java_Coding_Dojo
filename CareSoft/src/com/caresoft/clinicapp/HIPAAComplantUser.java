package com.caresoft.clinicapp;

public interface HIPAAComplantUser {
	abstract boolean assignPin(int pin);

	abstract boolean accessAuthorized(Integer confirmedAuthID);

}
