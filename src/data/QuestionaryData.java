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

public class QuestionaryData implements CrudItf<Donor> {

	@Override
	public List<Questionary> listAll() throws ConnectException {

		List<Questionary> lista = new ArrayList<>();

		try {
			String query = "SELECT *  FROM questionary";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Questionary(	rs.getString("id"), 
										rs.getString("screening")));
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
	public Questionary select(int id) throws ConnectException {
		Questionary questionary = new Questionary();

		try {
			String query = "SELECT * FROM questionary WHERE id_questionary = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				questionary = new Questionary(rs.getString("id"), 
									rs.getString("screening")));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return questionary;
	}

	@Override
	public Address save(Questionary obj) throws ConnectException {
		try {
			String query = "INSERT INTO questionary VALUES(?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.screening());
			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}
//Este método nao poderá ser implementado
	@Override
	public void delete(Questionary obj) throws ConnectException {
	}
//Este método não poderá ser implemntado
	@Override
	public Donor update(Questionary obj) throws ConnectException {
	}

}
