package data;

import java.util.List;

public interface CrudItf<T> {
	
	//public final String connection = "jdbc:sqlserver://rdsweb.usb.org.br;databaseName=ROBINBLOOD;user=robin.blood;password=beahero";
	public final String connection = "jdbc:sqlserver://192.168.0.4;databaseName=ROBINBLOOD;user=sa;password=123456";
	
	public List<T> listAll() throws ConnectException;
	public T select(int id) throws ConnectException;
	public T update(T obj) throws ConnectException;
	public T save(T obj) throws ConnectException;
	public void delete(T obj) throws ConnectException;
}
