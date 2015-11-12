package business;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import data.ConnectException;
import data.DonorPhoneData;
import data.PhoneData;
import models.DonorPhone;
import models.Phone;

public class DonorPhoneController {
	private PhoneData phoneData;
	private DonorPhoneData donorphoneData;

	public DonorPhoneController(){
		phoneData = new PhoneData();
	}

	public List<Phone> getAll() {
		List<Phone> result = null;
		try {
			result = phoneData.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<Phone> getByFilter(int filter) {
		List<Phone> result = null;
		try {
			result =  phoneData.listAllDonorPhone(filter);
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public DefaultTableModel getTableModel(List<Phone> phones) {
		DefaultTableModel model = new DefaultTableModel(new String[] { "Número" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		for (Phone phone : phones) {
			Object[] o = new Object[3];
			o[0] = phone.getNumber();


			model.addRow(o);
		}

		return model;
	}


	public Object save(DonorPhone donorphone) throws ConnectException {
		return donorphoneData.save(donorphone);
		

	}

	public void delete(Phone phone) throws ConnectException {
		phoneData.delete(phone);
	}

}
