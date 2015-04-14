package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.AgencyServicesLocal;
import services.interfaces.AgencyServicesRemote;
import domain.Agency;
import domain.Car;

/**
 * Session Bean implementation class AgencyServices
 */
@Stateless
public class AgencyServices implements AgencyServicesRemote,
		AgencyServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AgencyServices() {
	}

	@Override
	public List<Agency> findAllAgencies() {
		return entityManager
				.createQuery("select a from Agency a", Agency.class)
				.getResultList();
	}

	@Override
	public List<Car> findAllCarsByAgencyId(Integer idAgency) {
		return entityManager
				.createQuery("select c from Car c where c.agency.id =:param",
						Car.class).setParameter("param", idAgency)
				.getResultList();

	}

}
