package br.com.unb.entity;

public class Offer {

	private int id;
	private int subjects;
	private String halfYear;
	private int studentsAmount;
	private boolean isMandatory;
	private int scholarShip;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubjects() {
		return subjects;
	}
	public void setSubjects(int subjects) {
		this.subjects = subjects;
	}
	public String getHalfYear() {
		return halfYear;
	}
	public void setHalfYear(String half_year) {
		this.halfYear = half_year;
	}
	public int getStudentsAmount() {
		return studentsAmount;
	}
	public void setStudentsAmount(int studentsAmount) {
		this.studentsAmount = studentsAmount;
	}
	public boolean getIsMandatory() {
		return isMandatory;
	}
	public void setIsMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}
	public int getScholarShip() {
		return scholarShip;
	}
	public void setScholarShip(int scholarShip) {
		this.scholarShip = scholarShip;
	}	
}