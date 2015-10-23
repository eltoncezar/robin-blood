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

public class DonorData implements CrudItf<Donor> {

	@Override
	public List<Donor> listAll() throws ConnectException {

		List<Donor> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM Donor";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Donor(rs.getInt("id_donor"),
						rs.getString("name"), rs.getString("cpf"), rs
								.getString("gender"), rs.getString("email"), rs
								.getString("bloodType"), null, null));
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
	public Donor select(int id) throws ConnectException {
		Donor donor = new Donor();

		try {
			String query = "SELECT * FROM Donor WHERE id_donor=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				donor = new Donor(rs.getInt("id_donor"), rs.getString("name"),
						rs.getString("cpf"), rs.getString("gender"),
						rs.getString("email"), rs.getString("bloodType"), null,
						null);
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
	public Donor save(Donor obj) throws ConnectException {
		try {
			String query = "INSERT INTO Donor VALUES(?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, obj.getId());
			stmt.setString(2, obj.getName());
			stmt.executeUpdate();

			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Donor obj) throws ConnectException {
		try {
			String query = "DELETE FROM Donor WHERE donor_name=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getName());
			stmt.executeUpdate();

			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public Donor update(Donor obj) throws ConnectException {
		return null;
	}

}
