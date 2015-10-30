package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Utils;
import models.Inventary;

public class InventaryData implements CrudItf<Inventary>{

	@Override
	public List<Inventary> listAll() throws ConnectException {
		List<Inventary> lista = new ArrayList<>();
		

		try {
			String query = "SELECT * FROM inventary";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Inventary(rs.getInt("id_inventary"),
						rs.getInt("id_product"),
						rs.getInt("inventary_amount"),
						rs.getDate("product_in_date"),
						rs.getDate("product_out_date")));		
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
	public Inventary select(int id) throws ConnectException {
		Inventary inventary = new Inventary();

		try {
			String query = "SELECT * FROM inventary WHERE id_inventary=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				inventary = new Inventary(rs.getInt("id_inventary"),
						rs.getInt("id_product"),
						rs.getInt("inventary_amount"),
						rs.getDate("product_in_date"),
						rs.getDate("product_out_date"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return inventary;
	}

	@Override
	public Inventary update(Inventary obj) throws ConnectException {
		Utils utils = new Utils();
		try{
			String query = "UPDATE inventary set id_product=?, inventary_amount=?, product_in_date=?,product_out_date=? WHERE id_inventary=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, Integer.toString(obj.getProduct()));
			stmt.setString(2, Integer.toString(obj.getAmount()));
			stmt.setString(3, utils.convertStringToDate(obj.getProductIn()));
			stmt.setString(4, utils.convertStringToDate(obj.getProductOut()));
			stmt.setString(5, Integer.toString(obj.getId()));
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

	@Override
	public Inventary save(Inventary obj) throws ConnectException {
		Utils utils = new Utils();
		try {
			String query = "INSERT INTO inventary VALUES(?,?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, Integer.toString(obj.getProduct()));
			stmt.setString(2, Integer.toString(obj.getAmount()));
			stmt.setString(3, utils.convertStringToDate(obj.getProductIn()));
			stmt.setString(4, utils.convertStringToDate(obj.getProductOut()));
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Inventary obj) throws ConnectException {
		try {
			String query = "DELETE inventary WHERE id_inventary=?";

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

}
