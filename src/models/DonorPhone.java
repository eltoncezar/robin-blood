package models;

public class DonorPhone {
	private int idPhone;
	private int idDonor;
	
	public DonorPhone() {
		super();
	}

	
	public DonorPhone(int idPhone, int idDonor) {
		super();
		this.idPhone = idPhone;
		this.idDonor = idDonor;
	}

	public int getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}

	public int getIdDonor() {
		return idDonor;
	}

	public void setIdDonor(int idDonor) {
		this.idDonor = idDonor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDonor;
		result = prime * result + idPhone;
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
		if (idDonor != other.idDonor)
			return false;
		if (idPhone != other.idPhone)
			return false;
		return true;
	}
	
	
	

	
}
