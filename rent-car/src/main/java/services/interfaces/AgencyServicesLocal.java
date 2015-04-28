package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import domain.Agency;
import domain.Car;
import domain.User;

@Local
public interface AgencyServicesLocal {
	List<Agency> findAllAgencies();

	List<Car> findAllCarsByAgencyId(Integer idAgency);

	Boolean createContract(Date beginDate, Date endDate, Car car, User user);

	Agency findAgencyByName(String name);
}
