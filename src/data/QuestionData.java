package data;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Question;

public class QuestionData implements CrudItf<Question> {

	@Override
	public List<Question> listAll() throws ConnectException {

		List<Question> lista = new ArrayList<>();

		try {
			String query = "SELECT *  FROM questions";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Question(rs.getInt("id_question"),
						rs.getString("question_description")));
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
	public Question select(int id) throws ConnectException {
		Question question = new Question();

		try {
			String query = "SELECT * FROM questions WHERE id_question = ?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				question = new Question(rs.getInt("id_question"),
						rs.getString("question_description"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return question;
	}

	@Override
	public Question save(Question obj) throws ConnectException {
		try {
			String query = "INSERT INTO questions VALUES(?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getDescription());
			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Question obj) throws ConnectException {
		try {
			String query = "DELETE questions WHERE id_question=?";

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

	@Override
	public Question update(Question obj) throws ConnectException {
		try{
			String query = "UPDATE questions SET question_description=? WHERE id_question=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getDescription());
			stmt.setString(2, String.valueOf(obj.getId()));
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
