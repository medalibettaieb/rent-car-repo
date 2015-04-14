package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Any;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import services.interfaces.AgencyServicesLocal;
import domain.Agency;
import domain.Car;

@ManagedBean
@Any
public class AgencyBean {
	private List<Agency> agencies = new ArrayList<>();
	private List<Car> carsByAgency = new ArrayList<>();
	private Integer idAgency;
	private DataModel<Agency> datamodel = new ListDataModel<>();
	private DataModel<Car> datamodelCars = new ListDataModel<>();
	@EJB
	private AgencyServicesLocal agencyServicesLocal;

	public String doSelectAgency() {
		Agency agencySelected = datamodel.getRowData();
		idAgency = agencySelected.getId();
		return "/pages/customerHome/listCarsByAgency";
	}

	public List<Agency> getAgencies() {
		agencies = agencyServicesLocal.findAllAgencies();
		return agencies;
	}

	public void setAgencies(List<Agency> agencies) {
		this.agencies = agencies;
	}

	public List<Car> getCarsByAgency() {
		carsByAgency = agencyServicesLocal.findAllCarsByAgencyId(idAgency);
		return carsByAgency;
	}

	public void setCarsByAgency(List<Car> carsByAgency) {
		this.carsByAgency = carsByAgency;
	}

	public DataModel<Agency> getDatamodel() {
		datamodel.setWrappedData(agencyServicesLocal.findAllAgencies());
		return datamodel;
	}

	public void setDatamodel(DataModel<Agency> datamodel) {
		this.datamodel = datamodel;
	}

	public DataModel<Car> getDatamodelCars() {
		datamodelCars.setWrappedData(agencyServicesLocal
				.findAllCarsByAgencyId(idAgency));
		return datamodelCars;
	}

	public void setDatamodelCars(DataModel<Car> datamodelCars) {
		this.datamodelCars = datamodelCars;
	}

}
