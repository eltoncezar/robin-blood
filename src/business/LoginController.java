package business;

import data.AddressData;
import data.DonorData;

public class LoginController {

	private DonorData donorData;
	private AddressData addressData;
	
	public LoginController() {
		donorData = new DonorData();
		addressData = new AddressData();
	}
	
	public boolean validateUser(String user, String password) {
		return true;
	}
}
