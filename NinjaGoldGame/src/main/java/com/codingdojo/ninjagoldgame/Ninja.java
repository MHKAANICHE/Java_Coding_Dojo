package com.codingdojo.ninjagoldgame;

public class Ninja {
private String name;
private Integer score;
public Ninja(String name, Integer score) {
	super();
	this.name = name;
	this.score = score;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getScore() {
	return score;
}
public void setScore(Integer score) {
	this.score = score;
}

}
