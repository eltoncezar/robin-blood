package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Session;
import models.Screening;

public class ScreeningData implements CrudItf<Screening> {

	@Override
	public List<Screening> listAll() throws ConnectException {
		try {
			List<Screening> lista = new ArrayList<>();
			
			String query = "SELECT * FROM screening";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Screening(rs.getInt("id_screening"),
						rs.getInt("id_donation")));		
			}
			rs.close();
			stmt.close();
			con.close();
			
			return lista;
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public Screening select(int id) throws ConnectException {
		try {
			Screening screening = new Screening();
			
			String query = "SELECT * FROM screening WHERE id_screening=?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				screening = new Screening(rs.getInt("id_screening"),
						rs.getInt("id_donation"));
			}
			rs.close();
			stmt.close();
			con.close();
			
			return screening;
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public Screening update(Screening obj) throws ConnectException {
		try {
			String query = "UPDATE screening set id_donation=?, WHERE id_screening=?";
			
			Connection con = DriverManager.getConnection(Session.getConnectionString()); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, obj.getIdDonation());
			stmt.setInt(2, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public Screening save(Screening obj) throws ConnectException {
		try {
			String query = "INSERT INTO screening VALUES(?)";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, obj.getIdDonation());
						
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Screening obj) throws ConnectException {
		try {
			String query = "DELETE screening WHERE id_screening=?";

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
