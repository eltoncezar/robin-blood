package business;

import models.User;

public final class Session {
	private static String connectionString = "jdbc:sqlserver://rdsweb.usb.org.br;databaseName=ROBINBLOOD;user=robin.blood;password=beahero";
	//private static String connectionString = "jdbc:sqlserver://10.15.11.121;databaseName=ROBINBLOOD;user=sa;password=123456";
	private static User loggedUser;
	
	private Session() {
	}

	public static String getConnectionString() {
		return connectionString;
	}

	public static User getLoggedUser() {
		return loggedUser;
	}

	public static void setLoggedUser(User loggedUser) {
		Session.loggedUser = loggedUser;
	}
}
