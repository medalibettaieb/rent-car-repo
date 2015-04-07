package domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
public class Customer extends User implements Serializable {

	private String address;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}

	public Customer(String name, String address) {
		super();
		this.address = address;
		this.setName(name);
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
