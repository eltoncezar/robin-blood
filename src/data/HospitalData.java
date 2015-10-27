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

public class HospitalData implements CrudItf<Donor> {

	@Override
	public List<Hospital> listAll() throws ConnectException {

		List<Hospital> lista = new ArrayList<>();

		try {
			String query = "SELECT *  FROM hospital";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Question(	rs.getString("id"), 
										rs.getString("name"),
										rs.getString("document"),
										rs.getString("address"),
										rs.getString("phones")));
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
	public Hospital select(int id) throws ConnectException {
		Hospital hospital = new Question();

		try {
			String query = "SELECT * FROM hospital WHERE id_hospital = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				hospital = new Hospital(rs.getString("id"), 
										rs.getString("name"),
										rs.getString("document"),
										rs.getString("address"),
										rs.getString("phones")));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return hospital;
	}

	@Override
	public Hospital save(Hospital obj) throws ConnectException {
		try {
			String query = "INSERT INTO hospital VALUES(?,?,?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.name());
			stmt.setString(2, obj.document());
			stmt.setString(3, obj.address());
			stmt.setString(4, obj.phones());
			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Hospital obj) throws ConnectException {
		try {
			String query = "DELETE hospital WHERE id_hospital=?";

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
	public Hospital update(Hospital obj) throws ConnectException {
		try{
			String query = "UPDATE hospital SET hosp_name=?, hosp_document=?"
											+ "WHERE id_hospital=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.name());
			stmt.setString(2, obj.document());
			stmt.setString(3, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
