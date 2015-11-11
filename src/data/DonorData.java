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
import models.Phone;

public class DonorData implements CrudItf<Donor> {
	
	AddressData addressData = new AddressData();
	PhoneData phoneData = new PhoneData();

	@Override
	public List<Donor> listAll() throws ConnectException {

		List<Donor> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM Donor";

			Connection con = DriverManager.getConnection(connection);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				lista.add(
						new Donor(
							rs.getInt("id_donor"),
							rs.getString("donor_name"),
							rs.getString("donor_cpf"),
							rs.getString("donor_gender"),
							rs.getString("donor_email"),
							rs.getString("donor_blood_type"),
							rs.getInt("id_address")
						)
					);
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
	public Donor select(int id) throws ConnectException {
		Donor donor = new Donor();

		try {
			String query = "SELECT * FROM Donor WHERE id_donor=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				donor = new Donor(
						rs.getInt("id_donor"),
						rs.getString("donor_name"),
						rs.getString("donor_cpf"),
						rs.getString("donor_gender"),
						rs.getString("donor_email"),
						rs.getString("donor_blood_type"),
						rs.getInt("id_address"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}

		return donor;
	}
	
	public List<Donor> selectByName(String filter) throws ConnectException {
		List<Donor> lista = new ArrayList<>();

		try {
			String query = "SELECT * FROM Donor WHERE donor_name like '%' + ? + '%'";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, filter);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(
					new Donor(
						rs.getInt("id_donor"),
						rs.getString("donor_name"),
						rs.getString("donor_cpf"),
						rs.getString("donor_gender"),
						rs.getString("donor_email"),
						rs.getString("donor_blood_type"),
						rs.getInt("id_address")
						
					)
				);
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
	public Donor save(Donor obj) throws ConnectException {
		if (obj.getId() != 0) {
			
			return this.update(obj);
		}
		try {
			
			String query = "INSERT INTO Donor VALUES(?,?,?,?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getCpf());
			stmt.setString(3, obj.getGender());
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getBloodType());
			stmt.setInt(6, obj.getAddresses());
			
			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Donor obj) throws ConnectException {
		try {
			String query = "DELETE Donor WHERE id_donor=?";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public Donor update(Donor obj) throws ConnectException {
		try{
			String query = "UPDATE DONOR set donor_name=?,donor_cpf=?,donor_gender=?,donor_email=?,donor_blood_type=? WHERE id_donor=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getCpf());
			stmt.setString(3, obj.getGender());
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getBloodType());
			stmt.setInt(6, obj.getId());
			stmt.executeUpdate();

			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
