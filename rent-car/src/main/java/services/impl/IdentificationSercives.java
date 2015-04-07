package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.IdentificationSercivesLocal;
import services.interfaces.IdentificationSercivesRemote;
import domain.User;

/**
 * Session Bean implementation class IdentificationSercives
 */
@Stateless
public class IdentificationSercives implements IdentificationSercivesRemote,
		IdentificationSercivesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public IdentificationSercives() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User login(String login, String passowrd) {
		User userFound = null;
		String jpql = "select u from User u where u.login = :param1 and u.password =:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", passowrd);
		try {
			userFound = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found ");
		}

		return userFound;
	}

}
