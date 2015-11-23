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
import models.Product;



public class ProductData implements CrudItf<Product> {

	@Override
	public List<Product> listAll() throws ConnectException {

		List<Product> lista = new ArrayList<>();

		try {
			String query = "SELECT *  FROM product";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Product(rs.getInt("id_product"),
						rs.getString("product_description"),
						rs.getString("product_blood_type")));
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
	public Product select(int id) throws ConnectException {
		Product product = new Product();

		try {
			String query = "SELECT * FROM product WHERE id_product = ?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getInt("id_product"),
						rs.getString("product_description"),
						rs.getString("product_blood_type"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return product;
	}

	@Override
	public Product save(Product obj) throws ConnectException {
		try {
			String query = "INSERT INTO product VALUES(?,?)";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getDescription());
			stmt.setString(2, obj.getBloodType());
			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}
	
	//Este método so vai funcionar se não houver registro do produto no inventário.
	@Override
	public void delete(Product obj) throws ConnectException {
		try {
			String query = "DELETE product WHERE id_product=?";

			Connection con = DriverManager.getConnection(Session.getConnectionString());
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}
	//Não é interressante que os usuários possam editar os produtos.
	@Override
	public Product update(Product obj) throws ConnectException {
		try{
			String query = "UPDATE product set product_description=?,"
											+ "product_blood_type=?"
											+ "WHERE id_product=?";
			
			Connection con = DriverManager.getConnection(Session.getConnectionString()); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getDescription());
			stmt.setString(2, obj.getBloodType());
			stmt.setInt(3, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
