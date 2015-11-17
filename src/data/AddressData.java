package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Address;

public class AddressData implements CrudItf<Address> {

	@Override
	public List<Address> listAll() throws ConnectException {

		List<Address> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM Address";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(
					new Address(
						rs.getInt("id_address"),
						rs.getString("address_street"), 
						rs.getInt("address_number"),
						rs.getString("address_country"),
						rs.getString("address_zip"), 
						rs.getString("address_state"),
						rs.getString("address_city")						
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
	public Address select(int id) throws ConnectException {
		Address address = null;

		try {
			String query = "SELECT * FROM Address WHERE id_address = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				address = new Address(
					rs.getInt("id_address"),
					rs.getString("address_street"), 
					rs.getInt("address_number"),
					rs.getString("address_country"),
					rs.getString("address_zip"),
					rs.getString("address_state"),
					rs.getString("address_city")
					
					
					
			);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return address;
	}
	
	public Address selectLestID() throws ConnectException {
		Address address = null;

		try {
			String query = "SELECT TOP 1 *	FROM address WHERE id_address <=id_address 	ORDER BY id_address DESC";
			
			

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				address = new Address(
					rs.getInt("id_address"),
					rs.getString("address_street"), 
					rs.getInt("address_number"),
					rs.getString("address_country"),
					rs.getString("address_zip"),
					rs.getString("address_state"),
					rs.getString("address_city")
					
					
					
			);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return address;
	}
	@Override
	public  Address save(Address obj) throws ConnectException {
		if (obj.getId() != 0) {
			
			return this.update(obj);
		}
		try {
			String query = "INSERT INTO Address VALUES(?,?,?,?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getStreet());
			stmt.setInt(2, obj.getNumber());
			stmt.setString(3, obj.getCountry());
			stmt.setString(4, obj.getZipCode());
			stmt.setString(5, obj.getState());
			stmt.setString(6, obj.getCity());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.selectLestID();
			
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Address obj) throws ConnectException {
		try {
			String query = "DELETE Address WHERE id_address=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, String.valueOf(obj.getId()));
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public Address update(Address obj) throws ConnectException {
		try{
			String query = "UPDATE Address set address_street=?, address_number=?, address_country=?, address_zip=?, address_state=?  address_city=? WHERE id_address=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getStreet());
			stmt.setInt(2, obj.getNumber());
			stmt.setString(3, obj.getCountry());
			stmt.setString(4, obj.getZipCode());
			stmt.setString(5, obj.getState());
			stmt.setString(6, obj.getCity());
			stmt.setInt(7, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
