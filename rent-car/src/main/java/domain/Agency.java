package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Agency
 *
 */
@Entity
public class Agency extends User implements Serializable {

	private String logo;
	private static final long serialVersionUID = 1L;

	private List<Car> cars;

	public Agency() {
		super();
	}

	public Agency(String name, String login, String password, String logo) {
		this.setName(name);
		this.setLogin(login);
		this.setPassword(password);
		this.setLogo(logo);
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@OneToMany(mappedBy = "agency", cascade = CascadeType.PERSIST)
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public void linkCarsToThisAgency(List<Car> cars) {
		this.cars = cars;
		for (Car c : cars) {
			c.setAgency(this);
		}
	}

}
