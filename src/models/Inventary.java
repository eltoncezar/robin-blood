package models;

import java.util.Date;

public class Inventary {
	private int id;
	private Date productOut;
	private Date productIn;
	private int amount;
	private int product;




	public Inventary() {
		super();
	}

	public Inventary(int id, int product, int amount, Date productIn,
			Date productOut) {
		super();
		this.id = id;
		this.product = product;
		this.amount = amount;
		this.productIn = productIn;
		this.productOut = productOut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getProductIn() {
		return productIn;
	}

	public void setProductIn(Date productIn) {
		this.productIn = productIn;
	}

	public Date getProductOut() {
		return productOut;
	}

	public void setProductOut(Date productOut) {
		this.productOut = productOut;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.product + ": " + this.amount;
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
		Inventary other = (Inventary) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
