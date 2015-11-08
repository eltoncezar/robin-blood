package models;


public class Questionary {
	private int id;
	private int idScreening;

	public Questionary() {
		super();
	}

	public Questionary(int id, int idScreening) {
		super();
		this.id = id;
		this.idScreening = idScreening;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdScreening() {
		return idScreening;
	}

	public void setIdScreening(int idScreening) {
		this.idScreening = idScreening;
	}

	@Override
	public String toString() {
		return "Questionary [id=" + id + ", idScreening=" + idScreening + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idScreening;
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
		Questionary other = (Questionary) obj;
		if (id != other.id)
			return false;
		if (idScreening != other.idScreening)
			return false;
		return true;
	}

	

}
	

	
