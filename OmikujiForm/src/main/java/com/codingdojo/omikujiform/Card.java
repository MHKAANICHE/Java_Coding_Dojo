package com.codingdojo.omikujiform;

public class Card {

private Integer luckyNumber;
private String cityName;
private String userName;
private String userProfession;
private String livingThing;
private String message ;

public Card(Integer luckyNumber, String cityName, String userName, String userProfession, String livingThing,
		String message) {
	super();
	this.luckyNumber = luckyNumber;
	this.cityName = cityName;
	this.userName = userName;
	this.userProfession = userProfession;
	this.livingThing = livingThing;
	this.message = message;
}

public Integer getLuckyNumber() {
	return luckyNumber;
}

public void setLuckyNumber(Integer luckyNumber) {
	this.luckyNumber = luckyNumber;
}

public String getCityName() {
	return cityName;
}

public void setCityName(String cityName) {
	this.cityName = cityName;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserProfession() {
	return userProfession;
}

public void setUserProfession(String userProfession) {
	this.userProfession = userProfession;
}

public String getLivingThing() {
	return livingThing;
}

public void setLivingThing(String livingThing) {
	this.livingThing = livingThing;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}



}
