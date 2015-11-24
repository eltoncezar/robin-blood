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
import models.Collection;

public class CollectionData implements CrudItf<Collection> {
//teste do elton1
	@Override
	public List<Collection> listAll() throws ConnectException {
		List<Collection> lista = new ArrayList<>();
		

		try {
			String query = "SELECT * FROM collection";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Collection(rs.getInt("id_collection"),
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
	public Collection select(int id) throws ConnectException {
		Collection collection = new Collection();

		try {
			String query = "SELECT * FROM collection WHERE id_collection=?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				collection = new Collection(rs.getInt("id_collection"),
						rs.getInt("id_donation"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return collection;
	}

	@Override
	public Collection update(Collection obj) throws ConnectException {
		try{
			String query = "UPDATE Collection set  id_donation=? WHERE id_collection=?";
			
			Connection con = DriverManager.getConnection(Session.getConnectionString()); 
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
	public Collection save(Collection obj) throws ConnectException {
		try {
			String query = "INSERT INTO collection VALUES(?,?)";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, Integer.toString(obj.getId()));
			stmt.setString(2, Integer.toString(obj.getIdDonation()));
						
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Collection obj) throws ConnectException {
		try {
			String query = "DELETE Collection WHERE id_collection=?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
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
