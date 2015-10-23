package data;

import java.util.List;

public interface CrudItf<T> {
	
	public final String connection = "jdbc:sqlserver://localhost;databaseName=BIBLIOTECA;user=sa;password=123456";
	
	public List<T> listAll() throws ConnectException;
	public T select(int id) throws ConnectException;
	public T update(T obj) throws ConnectException;
	public T save(T obj) throws ConnectException;
	public void delete(T obj) throws ConnectException;
}
