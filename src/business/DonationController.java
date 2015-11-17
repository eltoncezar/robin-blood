package business;

import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import models.Donation;
import models.DonationStatus;
import models.Donor;
import models.Screening;
import models.Status;
import data.ConnectException;
import data.DonationData;
import data.DonationStatusData;
import data.DonorData;
import data.ScreeningData;
import data.StatusData;
import data.UserData;

public class DonationController {
	private DonationData donationData;
	private DonorData donorData;
	private DonationStatusData donationStatusData;
	private StatusData statusData;
	private UserData userData;
	private ScreeningData screeningData;

	public DonationController() {
		donationData = new DonationData();
		donorData = new DonorData();
		donationStatusData = new DonationStatusData();
		statusData = new StatusData();
		userData = new UserData();
		screeningData = new ScreeningData();
	}

	public Donation createNew(int donorId) {
		try {
			Donor donor = donorData.select(donorId);
			Status status = statusData.select(1);
			Date date = new Date();
			
			Donation donation = donationData.save(new Donation(0, donor, date, status, userData.select(1)));
			DonationStatus donationStatus = donationStatusData.save(new DonationStatus(donation, status, date));
			
			Screening screening = screeningData.save(new Screening(0, donation.getId()));

			return donation;

		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Donor getDonorByCpf(String cpf) {
		try {
			return donorData.selectByCpf(cpf);
		} catch (ConnectException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Donation> getLastDonations(int donorId) {
		try {
			return donationData.listAllByDonor(donorId);
		} catch (ConnectException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DonationStatus> getStatuses(int donationId) {
		try {
			return donationStatusData.listByDonation(donationId);
		} catch (ConnectException e) {
			e.printStackTrace();
			return null;
		}
	}

	public DefaultTableModel getDonationsTableModel(List<Donation> donations) {
		DefaultTableModel model = new DefaultTableModel(new String[] { "Id",
				"Data", "Status" }, 0) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		for (Donation donation : donations) {
			Object[] o = new Object[3];
			o[0] = donation.getId();
			o[1] = donation.getDonationDate();
			o[2] = donation.getStatus().getName();

			model.addRow(o);
		}

		return model;
	}

	public DefaultTableModel getStatusesTableModel(List<DonationStatus> statuses) {
		DefaultTableModel model = new DefaultTableModel(new String[] {
				"Data/Hora", "Status" }, 0) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		for (DonationStatus donationStatus : statuses) {
			Object[] o = new Object[2];
			o[0] = donationStatus.getDate();
			o[1] = donationStatus.getStatus();

			model.addRow(o);
		}

		return model;
	}
}
