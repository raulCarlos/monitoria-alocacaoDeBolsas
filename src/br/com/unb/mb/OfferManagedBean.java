package br.com.unb.mb;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.unb.bo.BOOffer;
import br.com.unb.entity.Offer;
import br.com.unb.exception.EmptyListException;
import br.com.unb.utils.ReturnMessage;

@ManagedBean(name="offerManagedBean")
@ViewScoped
public class OfferManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{boOffer}")
	private BOOffer bo;
	private List<Offer> listOffer;
	
	@PostConstruct
	public void init(){
		try {
			bo = new BOOffer();
			listOffer = bo.getOffers();
		} catch (SQLException e) {
			ReturnMessage.setMessage(e.getMessage(),"Erro de conexão: " , "fatal");
			e.printStackTrace();
		} catch (EmptyListException e) {
			ReturnMessage.setMessage(e.getMessage(),"Erro de consulta: " , "error");
			e.printStackTrace();
		}
	}

	public List<Offer> getListOffer() {
		return listOffer;
	}

	public void setListOffer(List<Offer> listOffer) {
		this.listOffer = listOffer;
	}

	public void setBo(BOOffer bo) {
		this.bo = bo;
	}
}
