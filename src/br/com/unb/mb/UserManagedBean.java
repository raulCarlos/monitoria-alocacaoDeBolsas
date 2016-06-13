package br.com.unb.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.unb.entity.User;
import br.com.unb.utils.PasswordEncryptor;
import br.com.unb.utils.ReturnMessage;

@ManagedBean(name="userManagedBean")
@ViewScoped
public class UserManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final String INDEX_PAGE  = "/pages/admin/index.xhtml";
	private static final String LOGOUT_PAGE = "/pages/login.xhtml";
	private User user;

	@PostConstruct
	public void init(){
		user = new User();
	}
	
	public String onClickLogin(){
		try {
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			req.login(this.user.getUsername(),  PasswordEncryptor.encrypt(user.getPassword()));
			return INDEX_PAGE;
		} catch (ServletException e) {
			ReturnMessage.setMessage("Erro ao logar: ", e.getMessage(), "error");
		} finally{
			//Tratar aki mensagens de segurança que possam vim
			//do login module exibindo-as na forma de FacesMessage
		}
		return null;
	}
	
	public String onClickLogout(){
		try {
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			req.logout();
			return LOGOUT_PAGE;
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String onClickRedirect(){
		return INDEX_PAGE;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}