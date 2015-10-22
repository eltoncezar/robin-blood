package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectDaoImp implements ConnecDaoItf {

	//String de conexão
	private final String connString = "jdbc:sqlserver://localhost;databaseName=BIBLIOTECA;user=sa;password=123456";
	
	//listar o id e o nome da tabela autor
	@Override
	public List<Autor> listAll() throws ConnectException {
		
		List<Autor> lista = new ArrayList<>();
		
		Connection con;
		try {
			con = DriverManager.getConnection(connString);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from autor");
			while(rs.next()){
				lista.add(new Autor(rs.getInt("id_autor"), rs.getString("nome_autor")));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	//Salvar um autor
	@Override
	public void save(Autor autor) throws ConnectException {
		Connection con;
		try {
			con = DriverManager.getConnection(connString);
			PreparedStatement stmt =con.prepareStatement("INSERT INTO AUTOR VALUES (?)");
			stmt.setString(1, autor.getNome());
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ConnectException(e.getMessage());
		}
		
	}
	
	//deletar um autor
	@Override
	public void delete(String nome) throws ConnectException {
		
		Connection con;
		try {
			con = DriverManager.getConnection(connString);
			PreparedStatement stmt =con.prepareStatement("DELETE FROM AUTOR WHERE nome_autor = ?");
			stmt.setString(1, nome);
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Autor select(String nome) throws ConnectException {
Autor autor = new Autor();
		
		Connection con;
		try {
			con = DriverManager.getConnection(connString);
			PreparedStatement stmt =con.prepareStatement("select * from autor where id_autor=?");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				autor.setId(rs.getInt("id_autor"));
				autor.setNome(rs.getString("nome_autor"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return autor;
	}

}
