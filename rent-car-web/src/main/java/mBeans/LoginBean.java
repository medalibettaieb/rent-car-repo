package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.IdentificationSercivesLocal;
import domain.Customer;
import domain.User;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {
	private User user = new User();
	private Boolean loggedInAsCustomer = false;
	@EJB
	private IdentificationSercivesLocal identificationSercivesLocal;

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = identificationSercivesLocal.login(user.getLogin(),
				user.getPassword());
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Customer) {
				loggedInAsCustomer = true;
				user = userLoggedIn;
				navigateTo = "/pages/customerHome/customerHome?faces-redirect=true";
			} else {
				user = userLoggedIn;
				navigateTo = "/pages/agencyHome/agencyHome?faces-redirect=true";
			}

		} else {
			navigateTo = "/error?faces-redirect=true";
		}

		return navigateTo;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsCustomer() {
		return loggedInAsCustomer;
	}

	public void setLoggedInAsCustomer(Boolean loggedInAsCustomer) {
		this.loggedInAsCustomer = loggedInAsCustomer;
	}

}
