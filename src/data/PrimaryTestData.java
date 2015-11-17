package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import models.PrimaryTest;


public class PrimaryTestData implements CrudItf<PrimaryTest> {
//Este método nao é relevante neste contexto,  pois os testes dependem da doação.
	@Override
	public List<PrimaryTest> listAll() throws ConnectException {
		return null;
	}
//Este metodo nao é relevante neste contexto.
	@Override
	public  PrimaryTest select(int id) throws ConnectException {
		return null;
	}
//Verificar esse método.
	@Override
	public PrimaryTest save(PrimaryTest obj) throws ConnectException {
		try {
			String query = "INSERT INTO primary_test VALUES(?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getResult());
			stmt.setInt(3, obj.getUser().getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}
//Não é possivel deletar um teste.
	@Override
	public void delete(PrimaryTest obj) throws ConnectException {
		
	}

	@Override
	public PrimaryTest update(PrimaryTest obj) throws ConnectException {
		try{
			String query = "UPDATE primary_test SET test_name=?, result_test=?, id_user=?, WHERE id_test=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getResult());
			stmt.setInt(3, obj.getUser().getId());
			stmt.setInt(4, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
