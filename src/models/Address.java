package models;

public class Address {
	private int id;
	private int id_donor;
	private String street;
	private int number;
	private String city;
	private String state;
	private String zipCode;
	private String country;

	public Address() {
		super();
	}

	public Address(int id,int id_donor, String street, int number, String city,
			String state, String zipCode, String country) {
		super();
		this.id = id;
		this.id_donor =id_donor;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdDonor() {
		return id_donor;
	}

	public void setIdDonor(int id) {
		this.id_donor = id_donor;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.street + ", " + this.number + ", "
				+ this.city + " - " + this.state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Address other = (Address) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
