package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.UserType;

public class UserTypeData implements CrudItf<UserType> {

	@Override
	public List<UserType> listAll() throws ConnectException {
		List<UserType> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM user_type";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new UserType(rs.getInt("id_type"),
						rs.getString("type_name")));
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
	public UserType select(int id) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserType update(UserType obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserType save(UserType obj) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UserType obj) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

}
