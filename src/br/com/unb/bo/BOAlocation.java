package br.com.unb.bo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import br.com.unb.dao.DAODepartament;
import br.com.unb.dao.DAOOffer;
import br.com.unb.dao.DAOScholarShip;
import br.com.unb.entity.ComparatorOffer;
import br.com.unb.entity.Departament;
import br.com.unb.entity.Offer;
import br.com.unb.entity.ScholarShip;
import br.com.unb.exception.EmptyListException;

public class BOAlocation {

	DAOOffer daoOffer = new DAOOffer();
	DAOScholarShip daoSSN = new DAOScholarShip();
	DAODepartament daoDep = new DAODepartament();
	
	public ScholarShip getShipNumberAmount(Departament dep) throws SQLException{
		return daoSSN.getScholarShipByDepartment(dep);
	}
	
	public List<ScholarShip> getAllScholatShip() throws SQLException, EmptyListException{
		List<ScholarShip> list = daoSSN.getAllScholarShip();
		if(!list.isEmpty()){
			return list;
		}
		throw new EmptyListException("Não há bolsas cadastradas!");
	}
	
	
	public void startAllocation() throws SQLException{
		List<Departament> listDep = daoDep.getDepartamentList();
		for(Departament dep : listDep){
			//Seleção de lista de ofertas por departamento e de bolsas disponíveis por departamento
			List<Offer> listOff =  daoOffer.getOfferByDepartment(dep);
			ScholarShip ship = daoSSN.getScholarShipByDepartment(dep);
			
			//Ordenação da lista de ofertas por maior número de alunos cadastrados
			Comparator<Offer> cres = new ComparatorOffer();
			Comparator<Offer> desc = Collections.reverseOrder(cres);
			Collections.sort(listOff, desc);
			
			int numberShip = ship.getAmount();
			Offer off;

			while(scholarShipAndStudentsDiffVerify(listOff) && numberShip > 0){
				int cont = 0;
				while(numberShip > 0 && cont < listOff.size()){
					off = listOff.remove(cont);
					
					int shipDif = off.getStudentsAmount() - off.getScholarShip();
					
					if(off.getIsMandatory() && shipDif > 0){
						off.setScholarShip(off.getScholarShip() + 1);
						numberShip = numberShip - 1;
						listOff.add(cont, off);
					}else{
						listOff.add(cont, off);
					}
					cont++;
				}
				
				if(numberShip > 0){
					cont = 0;
					while(numberShip > 0 && cont < listOff.size()){
						off =listOff.remove(cont);
						
						int shipDif = off.getStudentsAmount() - off.getScholarShip();
						
						if(!off.getIsMandatory() && shipDif > 0){
							off.setScholarShip(off.getScholarShip() + 1);
							numberShip = numberShip - 1;
							listOff.add(cont, off);
						}else{
							listOff.add(cont, off);
						}
						cont++;
					}
				}
			}
			
			ship.setAmount(numberShip);
			daoSSN.updateScholarShipByDepartament(ship, dep);
			
			Iterator<Offer> it = listOff.iterator();
			while(it.hasNext()){
				off = it.next();
				daoOffer.updateOffer(off);
			}
		}
	}
	
	private boolean scholarShipAndStudentsDiffVerify(List<Offer> list){
		for(Offer off : list){
			int shipDif = off.getStudentsAmount() - off.getScholarShip();
			if(shipDif > 0){
				return true;
			}
		}
		return false;
	}
}