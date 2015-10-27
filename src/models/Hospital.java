package models;

import java.util.List;
//Verificar lista de telefones. Se for o caso será preciso implementar no banco uma nova tabela de ligação.
public class Hospital {
	private int id;
	private String name;
	private String document;
	private Address address;
	private Phone phone;

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
		Hospital other = (Hospital) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
