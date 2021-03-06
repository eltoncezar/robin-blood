package business;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import data.ConnectException;
import data.UserData;
import data.UserTypeData;
import models.User;
import models.UserType;

public class UserRegistrationController {

	private UserData userData;
	private UserTypeData userTypeData;

	public UserRegistrationController() {
		userData = new UserData();
		userTypeData = new UserTypeData();
	}

	public List<User> getAll() {
		List<User> result = null;
		try {
			result = userData.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<User> getByFilter(String filter) {
		List<User> result = null;
		try {
			result = userData.selectByName(filter);
			if(result.size() == 0){
				
			}
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public DefaultTableModel getTableModel(List<User> users) {
		DefaultTableModel model = new DefaultTableModel(new String[] { "Id", "Nome", "E-mail" }, 0) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};

		for (User user : users) {
			Object[] o = new Object[3];
			o[0] = user.getId();
			o[1] = user.getName();
			o[2] = user.getEmail();

			model.addRow(o);
		}

		return model;
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
