package models;



public class Donor {
	private int id = 0;
	private String name;
	private String cpf;
	private String gender;
	private String email;
	private String bloodType;
	private Address address;
	private static Donor donor;
	
	public static Donor getInstace(){
		if(donor == null){
			donor = new Donor();
    	}
		
		return donor;
		
	}

	public Donor() {
		super();
	}

	public Donor(int id, String name, String cpf, String gender, String email,
			String bloodType,  Address address) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.gender = gender;
		this.email = email;
		this.bloodType = bloodType;
		this.address = address;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public Address getAddresses() {
		return address;
	}

	public void setAddresses(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "[" + this.id + "] " + this.name;
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
		Donor other = (Donor) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
