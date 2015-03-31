package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Car
 *
 */
@Entity
public class Car implements Serializable {

	private Integer matriculation;
	private String color;
	private String brand;
	private Float price;
	private static final long serialVersionUID = 1L;

	private Agency agency;

	public Car() {
		super();
	}

	@Id
	public Integer getMatriculation() {
		return this.matriculation;
	}

	public void setMatriculation(Integer matriculation) {
		this.matriculation = matriculation;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@ManyToOne
	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

}
