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
import models.DonationStatus;

public class DonationStatusData implements CrudItf<DonationStatus> {
	
	private DonationData donationData = new DonationData();
	private StatusData statusData = new StatusData();
	
	@Override
	public List<DonationStatus> listAll() throws ConnectException {
		List<DonationStatus> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM user_type";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(
					new DonationStatus(
						donationData.select(rs.getInt("id_donation")),
						statusData.select(rs.getInt("id_status")),
						rs.getDate("date")
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
	public DonationStatus select(int id) throws ConnectException {
		throw new UnsupportedOperationException();
	};
	
	public List<DonationStatus> listByDonation(int donationId) throws ConnectException {
		try {
			List<DonationStatus> lista = new ArrayList<>();
			
			String query = "SELECT * FROM donation_status WHERE id_donation=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, donationId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(
					new DonationStatus(
						donationData.select(rs.getInt("id_donation")),
						statusData.select(rs.getInt("id_status")),
						rs.getDate("date")
					)
				);
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
	public DonationStatus update(DonationStatus obj) throws ConnectException {
		throw new UnsupportedOperationException();
	}

	@Override
	public DonationStatus save(DonationStatus obj) throws ConnectException {
		try {
			String query = "INSERT INTO donation_status VALUES(?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			
			stmt.setInt(1, obj.getDonation().getId());
			stmt.setInt(2, obj.getStatus().getId());
			stmt.setDate(3, (Date) obj.getDate());			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getDonation().getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(DonationStatus obj) throws ConnectException {
		try {
			String query = "DELETE donation_status WHERE id_donation = ? AND id_status = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, obj.getDonation().getId());
			stmt.setInt(2, obj.getStatus().getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}
}