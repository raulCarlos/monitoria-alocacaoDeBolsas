package br.com.unb.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ReturnMessage {

	private static String ERROR  = "error";
	private static String FATAL = "fatal";
	private static String ALERT = "alert";
	private static String INFO  = "info";
	
	
	public static void setMessage(String label, String msg, String type){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(type == ERROR){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, label, msg));
		}else if(type == FATAL){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, label));
		}else if(type == ALERT){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, label));
		}else if(type == INFO){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, label));
		}	
	}
}
