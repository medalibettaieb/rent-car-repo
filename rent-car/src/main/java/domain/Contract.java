package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity
public class Contract implements Serializable {

	private ContractId contractId;
	private Date beginDate;
	private Date endDate;
	private static final long serialVersionUID = 1L;

	private User user;
	private Car car;

	public Contract() {
		super();
	}

	public Contract(Date beginDate, Date endDate, User user, Car car) {
		this.contractId = new ContractId(user.getId(), car.getMatriculation());
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.user = user;
		this.car = car;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@EmbeddedId
	public ContractId getContractId() {
		return contractId;
	}

	public void setContractId(ContractId contractId) {
		this.contractId = contractId;
	}

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "idCar", referencedColumnName = "matriculation", updatable = false, insertable = false)
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
