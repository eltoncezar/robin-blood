package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserData implements CrudItf<User> {
	
	
	@Override
	public List<User> listAll() throws ConnectException {
		List<User> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM [User]";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(
					new User(
						rs.getString("user_name"),
						rs.getInt("id_user"),
						rs.getString("user_password"),
						rs.getString("user_email"),
						rs.getInt("id_type"),
						rs.getInt("id_screening")
						
					)
				);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return lista;
	}

	@Override
	public User select(int id) throws ConnectException {
		User User = new User();

		try {
			String query = "SELECT * FROM [User] WHERE id_user=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User = new User(
					rs.getString("user_name"),
					rs.getInt("id_user"),
					rs.getString("user_password"),
					rs.getString("user_email"),
					rs.getInt("id_type"),
					rs.getInt("id_screning")
				);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return User;
	}
	
	public List<User> selectByName(String filter) throws ConnectException {
		List<User> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM [User] WHERE user_name like '%' + ? + '%'";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, filter);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(new User(
					rs.getString("user_name"),
					rs.getInt("id_user"),
					rs.getString("user_password"),
					rs.getString("user_email"),
					rs.getInt("id_type"),
					rs.getInt("id_screening")
				));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return lista;
	}

	@Override
	public User update(User obj) throws ConnectException {
		try{
			String query = "UPDATE [User]"
					+ "set user_name=?,"
					+ "user_password=?,"
					+ "user_email=?,"
					+ "id_type=?,"
					+ "id_screning"
					+ "WHERE id_user=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getPassword());
			stmt.setString(3, obj.getEmail());
			stmt.setInt(4, obj.getIdType());
			stmt.setInt(5, obj.getId());
			stmt.executeUpdate();

			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

	@Override
	public User save(User obj) throws ConnectException {
		
		if (obj.getId() != 0) {
			
			return this.update(obj);
		}
			
		try {
			String query = "INSERT INTO [User] VALUES(?,?,?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getPassword());
			stmt.setString(3, obj.getEmail());
			stmt.setInt(4, obj.getIdType());
			stmt.setInt(5, obj.getIdScreening());
			
			
			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(User obj) throws ConnectException {
		try {
			String query = "DELETE [User] WHERE id_user=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		
	}

}
