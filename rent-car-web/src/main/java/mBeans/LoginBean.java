package mBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String login;
	private String password;

	public String doLogin() {
		String navigateTo = "";
		if (login.equalsIgnoreCase("esprit")
				&& password.equalsIgnoreCase("esprit")) {
			navigateTo = "/pages/success?faces-redirect=true";
		} else {
			navigateTo = "/error?faces-redirect=true";
		}

		return navigateTo;

	}

	public String doDisconnect() {
		login = "";

		return "";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
