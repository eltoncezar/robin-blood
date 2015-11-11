package business;

import java.util.List;

import data.ConnectException;
import data.DonorPhoneData;
import data.PhoneData;
import models.DonorPhone;
import models.Phone;

public class DonorPhoneController {
	
	private DonorPhoneData donorphonedata;

	public DonorPhoneController(){
		donorphonedata = new DonorPhoneData();
	}

	public List<DonorPhone> getAll() {
		List<DonorPhone> result = null;
		try {
			result = donorphonedata.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}

		return result;
	}

	public DonorPhone getByFilterDonor(int filter) {
		DonorPhone result = null;
		try {
			result =  donorphonedata.select(filter);
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
