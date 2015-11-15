package data;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Phone;

public class PhoneData implements CrudItf<Phone> {

	@Override
	public List<Phone> listAll() throws ConnectException {

		List<Phone> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM Phone";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(
					new Phone(
						rs.getInt("id_phone"),
						rs.getString("phone_number")
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
	public Phone select(int id) throws ConnectException {
		Phone phone = null;

		try {
			String query = "SELECT * FROM Phone WHERE id_phone = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				phone = new Phone(
					rs.getInt("id_phone"),
					rs.getString("phone_number")
				);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return phone;
	}
	
	public Phone selectLast(int id) throws ConnectException {
		Phone phone = null;

		try {
			String query = "SELECT TOP 1 *	FROM phone WHERE id_phone <=id_phone ORDER BY id_phone DESC";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			//stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				phone = new Phone(
					rs.getInt("id_phone"),
					rs.getString("phone_number")
				);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return phone;
	}
	
	public List<Phone> listAllDonorPhone(int donorId) throws ConnectException {

		List<Phone> lista = new ArrayList<>();

		try {
			String query = "SELECT p.id_phone, p.phone_number "
					+ "FROM Donor_Phone dp "
					+ "INNER JOIN Phone p ON p.id_phone = dp.id_phone "
					+ "WHERE dp.id_donor = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, donorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(
					new Phone(
						rs.getInt("id_phone"),
						rs.getString("phone_number")
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
	public Phone save(Phone phon) throws ConnectException {
		try {
			String query = "INSERT INTO Phone VALUES(?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, phon.getNumber());
			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.selectLast(phon.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}
	
	
	public List<Phone> saveListPhone(List<Phone> phon) throws ConnectException {
		List<Phone> listanphone = new ArrayList<>();
		
		for (Phone phone : phon) {
			
			try {
				String query = "INSERT INTO Phone VALUES(?)";

				Connection con = DriverManager.getConnection(connection);
				PreparedStatement stmt = con.prepareStatement(query);

				stmt.setString(1,  phone.getNumber());
				
				
				stmt.executeUpdate();
				stmt.close();
				con.close();
				

				
				listanphone.add(selectLast(phone.getId()));
						
						
			} catch (SQLException e) {
				throw new ConnectException(e.getMessage());
			}
		}
		return listanphone;
	}

	@Override
	public void delete(Phone obj) throws ConnectException {
		try {
			String query = "DELETE Phone WHERE id_phone=?";

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

	@Override
	public Phone update(Phone obj) throws ConnectException {
		try{
			String query = "UPDATE phone set phone_number=?, WHERE id_phone=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getNumber());
			stmt.setInt(2, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
