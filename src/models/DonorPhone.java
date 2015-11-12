package models;

public class DonorPhone {
	private Phone Phone;
	private Donor Donor;
	
	public DonorPhone() {
		super();
	}

	
	public DonorPhone(Phone Phone, Donor Donor) {
		super();
		this.Phone = Phone;
		this.Donor = Donor;
	}


	public Phone getPhone() {
		return Phone;
	}


	public void setPhone(Phone Phone) {
		this.Phone = Phone;
	}


	public Donor getDonor() {
		return Donor;
	}


	public void setDonor(Donor Donor) {
		this.Donor = Donor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Donor == null) ? 0 : Donor.hashCode());
		result = prime * result + ((Phone == null) ? 0 : Phone.hashCode());
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
		DonorPhone other = (DonorPhone) obj;
		if (Donor == null) {
			if (other.Donor != null)
				return false;
		} else if (!Donor.equals(other.Donor))
			return false;
		if (Phone == null) {
			if (other.Phone != null)
				return false;
		} else if (!Phone.equals(other.Phone))
			return false;
		return true;
	}


	
	

	
}
