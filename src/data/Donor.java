package data;

import java.util.HashSet;

public class Donor {
	private int id;
	private String name;
	private String cpf;
	private String gender;
	private String email;
	private String bloodType;
	private HashSet<Address> addresses;
	private HashSet<Phone> phones;

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

	public HashSet<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(HashSet<Address> addresses) {
		this.addresses = addresses;
	}

	public HashSet<Phone> getPhones() {
		return phones;
	}

	public void setPhones(HashSet<Phone> phones) {
		this.phones = phones;
	}
}
