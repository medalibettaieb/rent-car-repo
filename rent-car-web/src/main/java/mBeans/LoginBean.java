package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.IdentificationSercivesLocal;
import domain.Customer;
import domain.User;

@ManagedBean
@SessionScoped
public class LoginBean {
	private User user = new User();
	@EJB
	private IdentificationSercivesLocal identificationSercivesLocal;

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = identificationSercivesLocal.login(user.getLogin(),
				user.getPassword());
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Customer) {
				System.out.println("customer");
			} else {
				System.out.println("agency");
			}

		} else {
			System.err.println("error");
		}

		return navigateTo;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
