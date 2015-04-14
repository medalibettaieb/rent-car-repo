package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Agency;
import domain.Car;

@Local
public interface AgencyServicesLocal {
	List<Agency> findAllAgencies();

	List<Car> findAllCarsByAgencyId(Integer idAgency);
}
