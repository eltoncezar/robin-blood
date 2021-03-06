package models;

public class Screening {
	private int id;
	private int idDonation;
	

	public Screening() {
		super();
	}


	public Screening(int id, int idDonation) {
		super();
		this.id = id;
		this.idDonation = idDonation;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdDonation() {
		return idDonation;
	}


	public void setIdDonation(int ifDonation) {
		this.idDonation = ifDonation;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idDonation;
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
		Screening other = (Screening) obj;
		if (id != other.id)
			return false;
		if (idDonation != other.idDonation)
			return false;
		return true;
	}

	
}
