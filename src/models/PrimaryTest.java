package models;

public class PrimaryTest {
	private int id;
	private String name;
	private String result;
	private User user;

	public PrimaryTest() {
		super();
	}

	public PrimaryTest(int id, String name, String result, User user) {
		super();
		this.id = id;
		this.name = name;
		this.result = result;
		this.user = user;
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
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		PrimaryTest other = (PrimaryTest) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
