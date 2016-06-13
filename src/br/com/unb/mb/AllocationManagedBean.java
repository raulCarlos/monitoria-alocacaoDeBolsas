package br.com.unb.mb;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.unb.bo.BOAlocation;
import br.com.unb.entity.ScholarShipNumber;
import br.com.unb.utils.ReturnMessage;

@ManagedBean(name="allocationManagedBean")
@ViewScoped
public class AllocationManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private BOAlocation bo = new BOAlocation();
	private ScholarShipNumber shipNumber;
	
	@PostConstruct
	public void init(){
		shipNumber = bo.getShipNumberAmount();
	}
	
	
	public void startAllocationProcess(){
		shipNumber.setAmount(bo.startAllocation());
		ReturnMessage.setMessage("Alocação Finalizada!","Status do Processo: " , "info");
	}

	public ScholarShipNumber getShipNumber() {
		return shipNumber;
	}
	public void setShipNumber(ScholarShipNumber shipNumber) {
		this.shipNumber = shipNumber;
	}
}
