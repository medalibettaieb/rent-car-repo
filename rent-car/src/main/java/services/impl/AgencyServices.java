package services.impl;

import java.util.List;

import javax.ejb.Stateless;

import domain.Agency;
import services.interfaces.AgencyServicesLocal;
import services.interfaces.AgencyServicesRemote;

/**
 * Session Bean implementation class AgencyServices
 */
@Stateless
public class AgencyServices implements AgencyServicesRemote, AgencyServicesLocal {

    /**
     * Default constructor. 
     */
    public AgencyServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Agency> findAllAgencies() {
		// TODO Auto-generated method stub
		return null;
	}

}
