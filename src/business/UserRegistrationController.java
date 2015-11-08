package business;

import java.util.List;

import models.User;
import models.UserType;
import data.ConnectException;
import data.UserData;
import data.UserTypeData;

public class UserRegistrationController {
	
	private UserData userData;
	private UserTypeData userTypeData;
	
	public UserRegistrationController() {
		userData = new UserData();
		userTypeData = new UserTypeData();
	}
	
	public List<User> getAll() throws ConnectException {
		return userData.listAll();
	}
	
	public List<User> getByFilter(String filter) throws ConnectException  {
		//TODO: implement
		return null;
	}
	
	public User save(User user) throws ConnectException {
		return userData.save(user);
	}
	
	public void delete(User user) throws ConnectException {
		userData.delete(user);
	}
	
	public List<UserType> getUserTypes() throws ConnectException {
		return userTypeData.listAll();
	}
}
