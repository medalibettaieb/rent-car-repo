package services.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Agency;
import domain.Car;
import domain.Customer;

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
	public void initDb() {
		Customer customer = new Customer("ra7ma", "ariana","r","r");
		Customer customer2 = new Customer("kawther", "bardo","k","k");
		Customer customer3 = new Customer("moez", "ghazela","m","m");
		Customer customer4 = new Customer("aymen", "tataouin","a","a");

		Agency agency = new Agency("yoo-voyage");

		Car car = new Car("179TU1111", "black", "symbole");
		Car car2 = new Car("179TU2222", "red", "504");
		Car car3 = new Car("179TU3333", "blue", "fiat");
		
		List<Car> cars=new ArrayList<>();
		
		cars.add(car);
		cars.add(car2);
		cars.add(car3);
		
		agency.linkCarsToThisAgency(cars);
		
		entityManager.persist(customer);
		entityManager.persist(customer2);
		entityManager.persist(customer3);
		entityManager.persist(customer4);
		
		entityManager.persist(agency);
		

	}

}
