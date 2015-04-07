package services.interfaces;

import javax.ejb.Remote;

import domain.User;

@Remote
public interface IdentificationSercivesRemote {
	User login(String login, String passowrd);
}
