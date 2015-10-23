package models;

import java.util.List;

public class Hospital {
	private int id;
	private String name;
	private String document;
	private Address address;
	private List<Phone> phones;

	public Hospital() {
		super();
	}

	public Hospital(int id, String name, String document, Address address,
			List<Phone> phones) {
		super();
		this.id = id;
		this.name = name;
		this.document = document;
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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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
