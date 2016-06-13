package br.com.unb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.unb.entity.Offer;

public class DAOOffer {

	public List<Offer> getAllOffers(){
		List<Offer> list = new ArrayList<Offer>();
		Offer of;
		int j = 69852;
		Random amount = new Random();
		
		for(int i = 0; i < 33; i++){
			of = new Offer();
			of.setId(i);
			of.setSubjects(++j);
			of.setHalfYear("2016/02");
			of.setStudentsAmount(amount.nextInt(41));
			of.setScholarShip(0);
			if((i == 10) || (i == 16) || (i == 21) || (i == 27) || (i == 32)){
				of.setIsMandatory(false);
			}else{
				of.setIsMandatory(true);
			}
			list.add(of);
		}		
		return list;
	}
}
