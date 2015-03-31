package domain;

import domain.User;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

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
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
   
}
