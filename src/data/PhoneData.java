package data;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Donor;

public class PhoneData implements CrudItf<Donor> {

	@Override
	public List<Phone> listAll() throws ConnectException {

		List<Phone> lista = new ArrayList<>();

		try {
			String query = "SELECT *  FROM phone";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Phone(	rs.getString("id"), 
										rs.getString("number")));
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
	public Phone select(int id) throws ConnectException {
		Phone phone = new Phone();

		try {
			String query = "SELECT * FROM phone WHERE id_phone = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				phone = new Address(rs.getString("id"), 
									rs.getString("number")));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return donor;
	}

	@Override
	public Address save(Phone obj) throws ConnectException {
		try {
			String query = "INSERT INTO phone VALUES(?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getNumber());
			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Address obj) throws ConnectException {
		try {
			String query = "DELETE phone WHERE id_phone=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public Donor update(Donor obj) throws ConnectException {
		try{
			String query = "UPDATE phone set phone_number=?,"
											+ "WHERE id_phone=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getNumber());
			stmt.setString(2, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
