package models;

public class Product {
	private int id;
	private String description;
	private String bloodType;

	public Product() {
		super();
	}

	public Product(int id, String description, String bloodType) {
		super();
		this.id = id;
		this.description = description;
		this.bloodType = bloodType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.description;
	}
}
