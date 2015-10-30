package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Screening;

public class ScreeningData implements CrudItf<Screening> {

	@Override
	public List<Screening> listAll() throws ConnectException {
		List<Screening> lista = new ArrayList<>();
		

		try {
			String query = "SELECT * FROM screening";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Screening(rs.getInt("id_screening"),
						rs.getInt("id_donation")));		
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
	public Screening select(int id) throws ConnectException {
		Screening screening = new Screening();

		try {
			String query = "SELECT * FROM screening WHERE id_screening=?";

			Connection con = DriverManager.getConnection(connection);
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
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return screening;
	}

	@Override
	public Screening update(Screening obj) throws ConnectException {
		try{
			String query = "UPDATE screening set id_donation=?, WHERE id_screening=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, Integer.toString(obj.getIdDonation()));
			stmt.setString(2, Integer.toString(obj.getId()));
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

	@Override
	public Screening save(Screening obj) throws ConnectException {
		try {
			String query = "INSERT INTO screening VALUES(?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, Integer.toString(obj.getIdDonation()));
						
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
