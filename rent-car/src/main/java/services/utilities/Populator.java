package services.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class Populator
 */
@Singleton
@Startup
public class Populator {

	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public Populator() {
        // TODO Auto-generated constructor stub
    }
    @PostConstruct
    public void initDb(){
    	
    }

}
