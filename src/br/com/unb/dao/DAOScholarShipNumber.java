package br.com.unb.dao;

import br.com.unb.entity.ScholarShipNumber;

public class DAOScholarShipNumber {

	public ScholarShipNumber getSSNumber(int value){
		ScholarShipNumber ssn = new ScholarShipNumber();
		ssn.setAmount(value);
		return ssn;
	}
	
}
