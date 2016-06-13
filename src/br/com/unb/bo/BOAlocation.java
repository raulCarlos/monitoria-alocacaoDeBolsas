package br.com.unb.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import br.com.unb.dao.DAOOffer;
import br.com.unb.dao.DAOScholarShipNumber;
import br.com.unb.entity.ComparatorOffer;
import br.com.unb.entity.Offer;
import br.com.unb.entity.ScholarShipNumber;

public class BOAlocation {

	DAOOffer daoOffer = new DAOOffer();
	DAOScholarShipNumber daoSSN = new DAOScholarShipNumber();
	
	public ScholarShipNumber getShipNumberAmount(){
		return daoSSN.getSSNumber(30);
	}
	
	public int startAllocation(){
		List<Offer> list = daoOffer.getAllOffers();
		ScholarShipNumber ship = daoSSN.getSSNumber(30);
		
		Iterator<Offer> it = list.iterator();
		List<Offer> listAllocOffer = new ArrayList<Offer>();
		
		List<Offer> listOfferRest = new ArrayList<Offer>();
		for(int i = ship.getAmount(); i > 0; i--){
			Offer off = new Offer();
			while(it.hasNext()){
				off = it.next();
				if(off.getIsMandatory() && off.getStudentsAmount() > 0){
					off.setScholarShip(1);
					int qtd = ship.getAmount() - 1;
					ship.setAmount(qtd);
					listAllocOffer.add(off);
				}else{
					listOfferRest.add(off);
				}
			}
		}	
		
	
		
		if(ship.getAmount() > 0){
			Comparator<Offer> cres = new ComparatorOffer();
			Comparator<Offer> desc = Collections.reverseOrder(cres);
			Collections.sort(listOfferRest, desc);
			
			System.out.println("Primeira Alocação");
			for(int j = 0; j < listOfferRest.size(); j++){
				System.out.println("ID: " + listOfferRest.get(j).getId());
				System.out.println("QTD Estudantes: " + listOfferRest.get(j).getStudentsAmount());
				System.out.println("--------------------------------------------------------");
			}
			
			
			
			Offer off = new Offer();
			int cont = 0;
			for(int x = ship.getAmount(); x > 0; x--){
				off = listOfferRest.get(cont);
				if(off.getStudentsAmount() > 0){
					off.setScholarShip(1);
					int qtd = ship.getAmount() - 1;
					ship.setAmount(qtd);
					listAllocOffer.add(off);
				}
				cont++;
			}
			System.out.println("Segunda Alocação");
			for(int y = 0; y < listOfferRest.size(); y++){
				if(listOfferRest.get(y).getScholarShip() == 0){
					System.out.println("ID: " + listOfferRest.get(y).getId());
					System.out.println("QTD Estudantes: " + listOfferRest.get(y).getStudentsAmount());
					System.out.println("--------------------------------------------------------");
				}
			}
		}
		
		return ship.getAmount();
	}
	
}
