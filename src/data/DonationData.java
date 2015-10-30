package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Utils;
import models.Donation;


public class DonationData implements CrudItf<Donation> {

	@Override
	public List<Donation> listAll() throws ConnectException {
		List<Donation> lista = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM donation";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Donation(rs.getInt("id_donation"),
						rs.getInt("id_donor"),
						rs.getDate("donation_date"),
						rs.getInt("id_status"),
						rs.getInt("id_user")));	
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
		Donation donation = new Donation();

		try {
			String query = "SELECT * FROM donation WHERE id_donation=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				donation = new Donation(rs.getInt("id_donation"),
						rs.getInt("id_donor"),
						rs.getDate("donation_date"),
						rs.getInt("id_status"),
						rs.getInt("id_user"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return donation;
	}

	@Override
	public Donation update(Donation obj) throws ConnectException {
		Utils utils = new Utils();
		try{
			String query = "UPDATE donation set id_donor=?,donation_date=?, id_status=?,id_user=?  WHERE id_donation=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, Integer.toString(obj.getIdDonor()));
			stmt.setString(2, utils.convertStringToDate(obj.getDonationDate()));
			stmt.setString(3, Integer.toString(obj.getIdStatus()));
			stmt.setString(4, Integer.toString(obj.getIdUser()));
			stmt.setString(5, Integer.toString(obj.getId()));
			stmt.executeUpdate();

			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

	@Override
	public Donation save(Donation obj) throws ConnectException {
		Utils utils = new Utils();
		try {
			String query = "INSERT INTO donation VALUES(?,?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, Integer.toString(obj.getIdDonor()));
			stmt.setString(2, utils.convertStringToDate(obj.getDonationDate()));
			stmt.setString(3, Integer.toString(obj.getIdStatus()));
			stmt.setString(4, Integer.toString(obj.getIdUser()));
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Donation obj) throws ConnectException {
		try {
			String query = "DELETE donation WHERE id_donation=?";

			Connection con = DriverManager.getConnection(connection);
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
