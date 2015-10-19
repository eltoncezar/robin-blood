package data;

import java.util.HashSet;

public class Screening {
	private int id;
	private HashSet<Donation> donations;
	private PrimaryTest test;
	private PrimaryTest resultTest;
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PrimaryTest getTest() {
		return test;
	}

	public void setTest(PrimaryTest test) {
		this.test = test;
	}

	public PrimaryTest getResultTest() {
		return resultTest;
	}

	public void setResultTest(PrimaryTest resultTest) {
		this.resultTest = resultTest;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HashSet<Donation> getDonation() {
		return donations;
	}

	public void setDonation(HashSet<Donation> donation) {
		this.donations = donation;
	}
}
