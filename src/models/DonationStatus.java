package models;

import java.util.Date;

public class DonationStatus {
	private Donation donation;
	private Status status;
	private Date date;

	public DonationStatus() {
		super();
	}

	public DonationStatus(Donation donation, Status status, Date date) {
		super();
		this.donation = donation;
		this.status = status;
		this.date = date;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
