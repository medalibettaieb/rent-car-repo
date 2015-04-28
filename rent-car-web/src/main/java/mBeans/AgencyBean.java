package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import services.interfaces.AgencyServicesLocal;
import domain.Agency;
import domain.Car;

@ManagedBean
@SessionScoped
public class AgencyBean {
	private List<Agency> agencies = new ArrayList<>();
	private List<Car> carsByAgency = new ArrayList<>();
	private Integer idAgency;
	private DataModel<Agency> datamodel = new ListDataModel<>();
	private DataModel<Car> datamodelCars = new ListDataModel<>();

	private Agency agencySelected;
	private Car carSelected;

	@ManagedProperty(value = "#{login}")
	private LoginBean loginBean;
	@EJB
	private AgencyServicesLocal agencyServicesLocal;

	public String doSelectAgency() {
		agencySelected = datamodel.getRowData();
		idAgency = agencySelected.getId();
		return "/pages/customerHome/listCarsByAgency";
	}

	public String doSelectCar() {
		carSelected = datamodelCars.getRowData();
		return "";
	}

	public String doCreateContract() {
		System.out.println(agencySelected.getName());
		System.out.println(carSelected.getMatriculation());
		System.out.println(loginBean.getUser().getName());
		return "";
	}

	public void doSomething() {
		System.out.println(agencySelected.getName());
	}

	public Agency doFindAgencyByName(String name) {
		return agencyServicesLocal.findAgencyByName(name);
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

	public Car getCarSelected() {
		return carSelected;
	}

	public void setCarSelected(Car carSelected) {
		this.carSelected = carSelected;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Agency getAgencySelected() {
		return agencySelected;
	}

	public void setAgencySelected(Agency agencySelected) {
		this.agencySelected = agencySelected;
	}

}
