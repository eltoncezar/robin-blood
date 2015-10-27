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

public class ProductData implements CrudItf<Donor> {

	@Override
	public List<Product> listAll() throws ConnectException {

		List<Product> lista = new ArrayList<>();

		try {
			String query = "SELECT *  FROM product";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(new Question(	rs.getString("id"), 
										rs.getString("description"),
										rs.getString("bloodType")));
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

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getString("id"), 
									rs.getString("description"),
									rs.getString("bloodType")));
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

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.description());
			stmt.setString(2, obj.bloodType());
			
			
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

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}
	//Não é interressante que os usuários possam editar os produtos.
	@Override
	public Product update(Question obj) throws ConnectException {
		try{
			String query = "UPDATE product set product_description=?,"
											+ "product_blood_type=?"
											+ "WHERE id_product=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.description());
			stmt.setString(2, obj.bloodType());
			stmt.setString(3, obj.id());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
