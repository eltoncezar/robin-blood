package data;

import java.util.List;

public interface CrudItf<T> {
	
	public final String connection = "jdbc:sqlserver:d:\\temp\\MeuPrimeiroBD";
	
	public List<T> listAll() throws CrudException;
	public T select(int id) throws CrudException;
	public T update(T obj) throws CrudException;
	public T save(T obj) throws CrudException;
	public void delete(T obj) throws CrudException;
}
