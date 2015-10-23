package models;

import java.util.Date;
import java.util.List;

public class Sale {
	private int id;
	private Hospital buyer;
	private int amount;
	private Date date;
	private List<Product> products;

	public Sale() {
		super();
	}

	public Sale(int id, Hospital buyer, int amount, Date date,
			List<Product> products) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.amount = amount;
		this.date = date;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hospital getBuyer() {
		return buyer;
	}

	public void setBuyer(Hospital buyer) {
		this.buyer = buyer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.date + " - " + this.buyer.getName();
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
		Sale other = (Sale) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
