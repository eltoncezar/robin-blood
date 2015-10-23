package models;

import java.util.Date;

public class Inventary {
	private int id;
	private Product product;
	private int amount;
	private Date productIn;
	private Date productOut;

	public Inventary() {
		super();
	}

	public Inventary(int id, Product product, int amount, Date productIn,
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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
}
