package models;

import java.util.Date;

public class Collection {
	private int id;
	private Donation donation;
	private Status status;
	private User user;
	private Date date;

	public Collection() {
		super();
	}

	public Collection(int id, Donation donation, Status status, User user,
			Date date) {
		super();
		this.id = id;
		this.donation = donation;
		this.status = status;
		this.user = user;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.donation.getUser().getName();
	}
}
