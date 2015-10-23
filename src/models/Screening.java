package models;

public class Screening {
	private int id;
	private Donation donation;
	private PrimaryTest test;
	private String resultTest;
	private User user;

	public Screening() {
		super();
	}

	public Screening(int id, Donation donation, PrimaryTest test,
			String resultTest, User user) {
		super();
		this.id = id;
		this.donation = donation;
		this.test = test;
		this.resultTest = resultTest;
		this.user = user;
	}

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

	public String getResultTest() {
		return resultTest;
	}

	public void setResultTest(String resultTest) {
		this.resultTest = resultTest;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.donation.getUser().getName();
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
		Screening other = (Screening) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
