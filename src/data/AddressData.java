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

public class AddressData implements CrudItf<Donor> {

	@Override
	public List<Address> listAll() throws ConnectException {

		List<Address> lista = new ArrayList<>();

		try {
			String query = "SELECT id_address, address_street, address_number,address_country, address_zip, address_state, address_city  FROM address";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Address(rs.getInt("id"),
										rs.getString("street"), 
										rs.setString("number"),
										rs.getString("city"),
										rs.getString("state"),
										rs.getString("cpf"),
										rs.getString("zipCode"), 
										rs.getString("country")));
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
		Address address = new Address();

		try {
			String query = "SELECT id_address, "
								+ "address_street, "
								+ "address_number,"
								+ "address_country, "
								+ "address_zip, "
								+ "address_state, "
								+ "address_city  "
					+ "FROM address"
					+ "WHERE id = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				donor = new Address(rs.getInt("id"),
						rs.getString("street"), 
						rs.setString("number"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getString("cpf"),
						rs.getString("zipCode"), 
						rs.getString("country")));
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
	public Address save(Address obj) throws ConnectException {
		try {
			String query = "INSERT INTO Address VALUES(?,?,?,?,?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getid_donor());
			stmt.setString(2, obj.getstreet());
			stmt.setString(3, obj.getnumber());
			stmt.setString(4, obj.getcity());
			stmt.setString(5, obj.getstate());
			stmt.setString(6, obj.zipCode());
			stmt.setString(7,obj.getcountry())
			
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
			String query = "DELETE Address WHERE id_address=?";

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
			String query = "UPDATE address set address_street=?,"
											+ "address_number=?,"
											+ "address_city=?"
											+ "address_state=? "
											+ "address_zip=?,"
											+ "address_country=?,"
											+ "WHERE id_address=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getStreet());
			stmt.setString(2, obj.getNumber());
			stmt.setString(3, obj.getCity());
			stmt.setString(4, obj.getState());
			stmt.setString(5, obj.zipCode());
			stmt.setString(6, obj.getCountry());
			stmt.setString(7, obj.getId)
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
