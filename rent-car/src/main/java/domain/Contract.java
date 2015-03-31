package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

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

	public Contract() {
		super();
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
   
}
