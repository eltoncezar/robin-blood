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
import models.Questionary;


public class QuestionaryData implements CrudItf<Questionary> {

	@Override
	public List<Questionary> listAll() throws ConnectException {

		List<Questionary> lista = new ArrayList<>();

		try {
			String query = "SELECT *  FROM questionary";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Questionary(rs.getInt("id_questionary"),
						rs.getInt("id_screening")));
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

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				questionary = new Questionary(rs.getInt("id_questionary"),
												rs.getInt("id_screening"));
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
	public Questionary save(Questionary obj) throws ConnectException {
		try {
			String query = "INSERT INTO questionary VALUES(?)";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, Integer.toString(obj.getIdScreening()));
			
			
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
	public Questionary update(Questionary obj) throws ConnectException {
		return null;
	}

}
