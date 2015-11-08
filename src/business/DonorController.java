 package business;
 
import java.util.List;

import javax.swing.table.DefaultTableModel;

import models.Donor;
import data.ConnectException;
import data.DonorData;

 public class DonorController {
	private DonorData donorData;

	public DonorController() {
		donorData = new DonorData();
	}

	public List<Donor> getAll() {
		List<Donor> result = null;
		try {
			result = donorData.listAll();
		} catch (ConnectException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<Donor> getByFilter(String filter) {
		List<Donor> result = null;
		try {
			result = donorData.selectByName(filter);
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

	public Donor save(Donor donor) throws ConnectException {
		return donorData.save(donor);
	}

	public void delete(Donor donor) throws ConnectException {
		donorData.delete(donor);
	}
 
 }
