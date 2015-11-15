package models;

import java.util.Date;

public class Donation {
	private int id;
	private Donor donor;
	private Date donationDate;
	private Status status;	
	private User user;

	public Donation() {
		super();
	}

	public Donation(int id, Donor donor, Date donationDate, Status status, User user) {
		super();
		this.id = id;
		this.donor = donor;
		this.donationDate = donationDate;
		this.status = status;
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

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((donationDate == null) ? 0 : donationDate.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donation other = (Donation) obj;
		if (donationDate == null) {
			if (other.donationDate != null)
				return false;
		} else if (!donationDate.equals(other.donationDate))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	
}