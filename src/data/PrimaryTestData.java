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

public class PrimaryTest implements CrudItf<Donor> {
//Este m�todo nao � relevante neste contexto,  pois os testes dependem da doa��o e doador.
	@Override
	public List<PrimaryTest> listAll() throws ConnectException {

	}
//Este metodo nao � relevante neste contexto.
	@Override
	public  PrimaryTest select(int id) throws ConnectException {
	
	}
//Verificar esse m�todo, para inserir ou remover os usu�rio.
	@Override
	public PrimaryTest save(PrimaryTest obj) throws ConnectException {
		try {
			String query = "INSERT INTO primary_test VALUES(?,?,?)";

			Connection con = DriverManager.getConnection(connection);
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getResult());
			stmt.setString(3, User.getId());
			
			
			stmt.executeUpdate();
			stmt.close();
			con.close();

			return this.select(obj.getId());
		} catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
	}

	@Override
	public void delete(Address obj) throws ConnectException {
		
	}

	@Override
	public Donor update(Donor obj) throws ConnectException {
		try{
			String query = "UPDATE primary_test SET result_test=?,"
											+ "WHERE id_test=?";
			
			Connection con = DriverManager.getConnection(connection); 
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, obj.getResult());
			stmt.setString(2, obj.getId());
			
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			throw new ConnectException(e.getMessage());
		}
		return null;
	}

}
