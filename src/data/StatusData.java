package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Status;

public class StatusData implements CrudItf<Status> {
	
	@Override
	public List<Status> listAll() throws ConnectException {
		List<Status> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM status";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(
					new Status(
						rs.getInt("id_status"),
						rs.getString("status_name")
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
	
	public List<Status> listAllByDonation(int donationId) throws ConnectException {
		List<Status> lista = new ArrayList<>();

		try {
			String query = "SELECT s.* FROM donation_status dp INNER JOIN status s ON s.id_status = dp.id_status WHERE id_donation = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, donationId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(
					new Status(
						rs.getInt("id_status"),
						rs.getString("status_name")
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
	public Status select(int id) throws ConnectException {
		Status result = new Status();

		try {
			String query = "SELECT * FROM status WHERE id_status = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result = new Status(
					rs.getInt("id_status"),
					rs.getString("status_name")
				);
			}
			rs.close();
			stmt.close();
			con.close();
			
			return result;
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

	}

	@Override
	public Status update(Status obj) throws ConnectException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Status save(Status obj) throws ConnectException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Status obj) throws ConnectException {
		throw new UnsupportedOperationException();
	}
}