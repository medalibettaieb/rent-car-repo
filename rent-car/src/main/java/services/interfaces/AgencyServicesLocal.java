package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Agency;

@Local
public interface AgencyServicesLocal {
	List<Agency> findAllAgencies();
}
