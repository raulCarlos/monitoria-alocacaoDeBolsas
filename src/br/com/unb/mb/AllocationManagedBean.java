package br.com.unb.mb;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.unb.bo.BOAlocation;
import br.com.unb.constant.Page;
import br.com.unb.entity.ScholarShip;
import br.com.unb.exception.EmptyListException;
import br.com.unb.utils.PagesMap;
import br.com.unb.utils.ReturnMessage;

@ManagedBean(name="allocationManagedBean")
@ViewScoped
public class AllocationManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private BOAlocation bo = new BOAlocation();
	private List<ScholarShip> listShip;
	
	@PostConstruct
	public void init(){
		try {
			listShip = bo.getAllScholatShip();
		} catch (SQLException e) {
			ReturnMessage.setMessage(e.getMessage(),"Erro de conexão: " , "fatal");
			e.printStackTrace();
		} catch (EmptyListException e) {
			ReturnMessage.setMessage(e.getMessage(),"Erro de consulta: " , "error");
			e.printStackTrace();
		}
	}
	
	public String startAllocationProcess(){
		try {
			bo.startAllocation();
			listShip = bo.getAllScholatShip();
			ReturnMessage.setMessage("Alocação Finalizada!","Status do Processo: " , "info");
			return PagesMap.getInstance().getMessage().get(Page.INDEX_PAGE);
		} catch (Exception e) {
			ReturnMessage.setMessage(e.getMessage(),"Falha no Processo: " , "fatal");
		}
		return null;
	}

	public List<ScholarShip> getListShip() {
		return listShip;
	}
	public void setListShip(List<ScholarShip> listShip) {
		this.listShip = listShip;
	}
}