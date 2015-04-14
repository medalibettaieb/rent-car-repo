package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Any;
import javax.faces.bean.ManagedBean;

import services.interfaces.AgencyServicesLocal;
import domain.Agency;

@ManagedBean
@Any
public class AgencyBean {
	private List<Agency> agencies = new ArrayList<>();
	@EJB
	private AgencyServicesLocal agencyServicesLocal;

	public List<Agency> getAgencies() {
		agencies = agencyServicesLocal.findAllAgencies();
		return agencies;
	}

	public void setAgencies(List<Agency> agencies) {
		this.agencies = agencies;
	}

}
