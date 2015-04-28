package mBeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import services.interfaces.AgencyServicesLocal;

@ManagedBean
@ViewScoped
public class ContractBean {
	private Date beginDate;
	private Date endDate;

	@ManagedProperty(value = "#{login}")
	private LoginBean loginBean;
	@ManagedProperty(value = "#{agencyBean}")
	private AgencyBean agencyBean;

	@EJB
	private AgencyServicesLocal agencyServicesLocal;

	public String doCreateContract() {
		agencyServicesLocal.createContract(beginDate, endDate,
				agencyBean.getCarSelected(), loginBean.getUser());
		return "";
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public AgencyBean getAgencyBean() {
		return agencyBean;
	}

	public void setAgencyBean(AgencyBean agencyBean) {
		this.agencyBean = agencyBean;
	}

}
