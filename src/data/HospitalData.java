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
import models.Address;
import models.Hospital;
import models.Phone;

public class HospitalData implements CrudItf<Hospital> {

	private AddressData addressData = new AddressData();
	private PhoneData phoneData = new PhoneData();

	@Override
	public List<Hospital> listAll() throws ConnectException {

		List<Hospital> lista = new ArrayList<>();

		try {
			String query = "SELECT *  FROM hospital";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(
					new Hospital(
						rs.getInt("id_hosp"),
						rs.getString("hosp_name"),
						rs.getString("hosp_document"),
						addressData.select(rs.getInt("id_address")),
						phoneData.select(rs.getInt("id_phone"))));
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
		Hospital hospital = null;

		try {
			String query = "SELECT * FROM Hospital WHERE id_hosp = ?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				hospital = new Hospital(
						rs.getInt("id_hosp"),
						rs.getString("hosp_name"),
						rs.getString("hosp_document"),
						addressData.select(rs.getInt("id_address")),
						phoneData.select(rs.getInt("id_phone")));
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
			Address address = addressData.save(obj.getAddress());
			Phone phone = phoneData.save(obj.getPhones());
			
			
			String query = "INSERT INTO Hospital VALUES(?,?,?,?,?)";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getDocument());
			stmt.setInt(3, address.getId());
			stmt.setInt(4, phone.getId());

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
			String query = "DELETE Hospital WHERE id_hosp=?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
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
	public Hospital update(Hospital obj) throws ConnectException {
		try {
			String query = "UPDATE Hospital SET hosp_name=?, hosp_document=? WHERE id_hosp=?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getDocument());
			stmt.setInt(3, obj.getId());

			stmt.executeUpdate();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
