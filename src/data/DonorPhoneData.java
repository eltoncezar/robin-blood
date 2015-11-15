package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.DonorPhone;

public class DonorPhoneData implements CrudItf<DonorPhone> {
	
	private DonorData donorData;

	@Override
	public List<DonorPhone> listAll() throws ConnectException {
		List<DonorPhone> lista = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM donor_phone";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
								
//				lista.add(new DonorPhone(rs.getInt("id_phone"),
//											rs.getInt("id_donor")));
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
	public DonorPhone select(int id) throws ConnectException {
		DonorPhone donorphone = new DonorPhone();

		try {
			String query = "SELECT * FROM donor_phone WHERE id_donor=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
//				donorphone = new DonorPhone(rs.getInt("id_phone"),
//						rs.getInt("id_donor"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return donorphone;
	}

	@Override
	public DonorPhone update(DonorPhone obj) throws ConnectException {
		try{
			String query = "UPDATE donor_phone set id_phone = ?  WHERE id_donor = ?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, obj.getPhone().getId());
			stmt.setInt(2, obj.getDonor().getId());
			
			
			stmt.executeUpdate();

			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

	@Override
	public DonorPhone save(DonorPhone obj) throws ConnectException {
		donorData = new DonorData();
		
		try {
			String query = "INSERT INTO donor_phone VALUES(?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			
			
			stmt.setInt(1, obj.getPhone().getId());
			stmt.setInt(2, donorData.selectLast().getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(DonorPhone obj) throws ConnectException {
		try {
			String query = "DELETE donor_phone WHERE id_phone=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, obj.getPhone().getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		
	}

	

}
