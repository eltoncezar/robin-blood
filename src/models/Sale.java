package models;

import java.util.Date;

public class Sale {
	private int id;
	private int buyer;
	private Date date;

	public Sale() {
		super();
	}

	public Sale(int id, int i, Date date) {
		super();
		this.id = id;
		this.buyer = i;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuyer() {
		return buyer;
	}

	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	
	@Override
	public String toString() {
		return "Sale [id=" + id + ", buyer=" + buyer + ", date=" + date + "]";
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
