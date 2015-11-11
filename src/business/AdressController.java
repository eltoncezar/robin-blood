package business;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import data.AddressData;
import data.ConnectException;
import data.DonorData;
import models.Address;
import models.Donor;

public class AdressController {
	private AddressData addressData;

	public AdressController() {
		addressData = new AddressData();
	}

	public List<Address> getAll() {
		List<Address> result = null;
		try {
			result = addressData.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Address getByFilter(int filter) {
		Address result = null;
		try {
			result =  addressData.select(filter);
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public DefaultTableModel getTableModel(List<Donor> donors) {
		DefaultTableModel model = new DefaultTableModel(new String[] { "Id", "Nome", "E-mail" }, 0) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};

		for (Donor donor : donors) {
			Object[] o = new Object[3];
			o[0] = donor.getId();
			o[1] = donor.getName();
			o[2] = donor.getEmail();

			model.addRow(o);
		}

		return model;
	}

	public int save(Address address) throws ConnectException {
		return addressData.save(address).getId();
		
	}

	public void delete(Address address) throws ConnectException {
		addressData.delete(address);
	}
 

}
