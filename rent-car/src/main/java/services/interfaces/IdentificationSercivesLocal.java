package services.interfaces;

import javax.ejb.Local;

import domain.User;

@Local
public interface IdentificationSercivesLocal {
	User login(String login, String passowrd);

}
