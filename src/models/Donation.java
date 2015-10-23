package models;

import java.util.Date;

public class Donation {
	private int id;
	private Donor donor;
	private Status status;
	private Date donationDate;
	private User user;

	public Donation() {
		super();
	}

	public Donation(int id, Donor donor, Status status, Date donationDate,
			User user) {
		super();
		this.id = id;
		this.donor = donor;
		this.status = status;
		this.donationDate = donationDate;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "[" + this.id + "] " + this.donor.getName();
	}
}