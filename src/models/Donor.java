package models;

import java.util.List;

public class Donor {
	private int id;
	private String name;
	private String cpf;
	private String gender;
	private String email;
	private String bloodType;
	private Address address;
	private List<Phone> phones;

	public Donor() {
		super();
	}

	public Donor(int id, String name, String cpf, String gender, String email,
			String bloodType, Address address, List<Phone> phones) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.gender = gender;
		this.email = email;
		this.bloodType = bloodType;
		this.address = address;
		this.phones = phones;
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

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.name;
	}
}
