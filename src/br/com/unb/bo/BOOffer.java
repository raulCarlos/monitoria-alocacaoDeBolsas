package br.com.unb.bo;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.unb.dao.DAOOffer;
import br.com.unb.entity.Offer;
import br.com.unb.exception.EmptyListException;

@ManagedBean(name="boOffer")
@ApplicationScoped
public class BOOffer {

	private DAOOffer dao = new DAOOffer();
	
	public List<Offer> getOffers() throws SQLException, EmptyListException{
		List<Offer> list = dao.getOffersList();
		if(!list.isEmpty()){
			return list;
		}
		throw new EmptyListException("Não há ofertas cadastradas na base de dados");
	}
}
