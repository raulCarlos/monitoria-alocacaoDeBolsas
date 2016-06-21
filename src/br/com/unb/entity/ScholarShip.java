package br.com.unb.entity;

public class ScholarShip {

	private int idScholarShip;
	private int amount;
	private Departament departament;
	/*private int idDepartment;
	private String department;*/ 
	private String halfYear;
	

	public int getIdScholarShip() {
		return idScholarShip;
	}
	public void setIdScholarShip(int idScholarShip) {
		this.idScholarShip = idScholarShip;
	}
	
	public Departament getDepartament() {
		return departament;
	}
	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	/*	public int getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}*/
	public String getHalfYear() {
		return halfYear;
	}
	public void setHalfYear(String halfYear) {
		this.halfYear = halfYear;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
