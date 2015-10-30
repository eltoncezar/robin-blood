package models;

import java.util.Date;

public class Donation {
	private int id;
	private int idDonor;
	private Date donationDate;
	private int idStatus;	
	private int idUser;

	public Donation() {
		super();
	}

	public Donation(int id, int idDonor, Date donationDate, int idStatus, int idUser) {
		super();
		this.id = id;
		this.idDonor = idDonor;
		this.donationDate = donationDate;
		this.idStatus = idStatus;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDonor() {
		return idDonor;
	}

	public void setIdDonor(int idDonor) {
		this.idDonor = idDonor;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((donationDate == null) ? 0 : donationDate.hashCode());
		result = prime * result + id;
		result = prime * result + idDonor;
		result = prime * result + idStatus;
		result = prime * result + idUser;
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
		if (idDonor != other.idDonor)
			return false;
		if (idStatus != other.idStatus)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	
}