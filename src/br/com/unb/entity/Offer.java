package br.com.unb.entity;

public class Offer {

	private int id;
	private int idSubject;
	private String subjectName;
	private String halfYear;
	private int studentsAmount;
	private boolean isMandatory;
	private String mandatoryLabel;
	private int scholarShip;
	private Departament departament;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSubject() {
		return idSubject;
	}
	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
	public String getMandatoryLabel() {
		return mandatoryLabel;
	}
	public void setMandatoryLabel(String mandatoryLabel) {
		this.mandatoryLabel = mandatoryLabel;
	}
	public int getScholarShip() {
		return scholarShip;
	}
	public void setScholarShip(int scholarShip) {
		this.scholarShip = scholarShip;
	}
	public Departament getDepartament() {
		return departament;
	}
	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
}