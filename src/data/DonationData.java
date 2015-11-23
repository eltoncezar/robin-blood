package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Session;
import models.Donation;


public class DonationData implements CrudItf<Donation> {
	
	DonorData donorData = new DonorData();
	StatusData statusData = new StatusData();
	UserData userData = new UserData();

	@Override
	public List<Donation> listAll() throws ConnectException {
		List<Donation> lista = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM donation";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(
					new Donation(
						rs.getInt("id_donation"),
						donorData.select(rs.getInt("id_donor")),
						rs.getDate("donation_date"),
						statusData.select(rs.getInt("id_status")),
						userData.select(rs.getInt("id_user"))
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
	
	public List<Donation> listAllByDonor(int donorId) throws ConnectException {
		List<Donation> lista = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM donation WHERE id_donor = ?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, donorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(
					new Donation(
						rs.getInt("id_donation"),
						donorData.select(rs.getInt("id_donor")),
						rs.getDate("donation_date"),
						statusData.select(rs.getInt("id_status")),
						userData.select(rs.getInt("id_user"))
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
	public Donation select(int id) throws ConnectException {
		try {
			Donation donation = new Donation();
			
			String query = "SELECT * FROM donation WHERE id_donation=?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				donation = new Donation(
					rs.getInt("id_donation"),
					donorData.select(rs.getInt("id_donor")),
					rs.getDate("donation_date"),
					statusData.select(rs.getInt("id_status")),
					userData.select(rs.getInt("id_user"))
				);
			}
			rs.close();
			stmt.close();
			con.close();
			
			return donation;
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public Donation update(Donation obj) throws ConnectException {
		try {
			String query = "UPDATE donation set id_donor=?,donation_date=?, id_status=?,id_user=?  WHERE id_donation=?";
			
			Connection con = DriverManager.getConnection(Session.getConnectionString()); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, obj.getDonor().getId());
			stmt.setDate(2, (Date) obj.getDonationDate());
			stmt.setInt(3, obj.getStatus().getId());
			stmt.setInt(4, obj.getUser().getId());
			stmt.setInt(5, obj.getDonor().getId());
			stmt.executeUpdate();

			stmt.close();
			con.close();
			return select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public Donation save(Donation obj) throws ConnectException {
		try {
			if (obj.getId() != 0) {
				return this.update(obj);
			}
			
			String query = "INSERT INTO donation VALUES(?,?,?,?)";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, obj.getDonor().getId());
			stmt.setDate(2, new java.sql.Date(obj.getDonationDate().getTime()));
			stmt.setInt(3, obj.getStatus().getId());
			stmt.setInt(4, obj.getUser().getId());
			stmt.executeUpdate();
			
			int newId = 0;
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				newId = rs.getInt(1);
			}
			
			stmt.close();
			con.close();

			return this.select(newId);
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Donation obj) throws ConnectException {
		try {
			String query = "DELETE donation WHERE id_donation=?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, Integer.toString(obj.getId()));
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

}
