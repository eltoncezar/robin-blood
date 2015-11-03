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
import models.Sale;


public class SaleData implements CrudItf<Sale> {

	@Override
	public List<Sale> listAll() throws ConnectException {
		List<Sale> lista = new ArrayList<>();
		

		try {
			String query = "SELECT * FROM Sale";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Sale(rs.getInt("is_sale"),
						rs.getInt("id_buyer"),
						rs.getDate("sale_date")));		
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
	public Sale select(int id) throws ConnectException {
		Sale sale = new Sale();

		try {
			String query = "SELECT * FROM Sale WHERE id_sale=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				sale = new Sale(rs.getInt("id_sale"),
						rs.getInt("id_buyer"),
						rs.getDate("sale_date"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return sale;
	}

	@Override
	public Sale update(Sale obj) throws ConnectException {
		Utils utils = new Utils();
		try{
			String query = "UPDATE Sale set id_buyer=?,sale_date=? WHERE id_sale=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, Integer.toString(obj.getBuyer()));
			stmt.setString(2, utils.convertStringToDate(obj.getDate()));
			stmt.setString(3, Integer.toString(obj.getId()));
			stmt.executeUpdate();

			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

	@Override
	public Sale save(Sale obj) throws ConnectException {
		Utils utils = new Utils();
		try {
			String query = "INSERT INTO Sale VALUES(?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, Integer.toString(obj.getId()));
			stmt.setString(2, Integer.toString(obj.getBuyer()));
			stmt.setString(3, utils.convertStringToDate(obj.getDate()));
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Sale obj) throws ConnectException {
		try {
			String query = "DELETE Sale WHERE id_sale=?";

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
