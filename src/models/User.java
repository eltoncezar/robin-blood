package models;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private UserType userType;

	public User() {
		super();
	}

	public User(int id, String name, String password, String email,
			UserType userType) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.userType = userType;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserTypeId(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] " + this.name;
	}
}
