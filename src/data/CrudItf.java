package data;

import java.util.List;

public interface CrudItf<T> {
	public List<T> listAll() throws ConnectException;
	public T select(int id) throws ConnectException;
	public T update(T obj) throws ConnectException;
	public T save(T obj) throws ConnectException;
	public void delete(T obj) throws ConnectException;
}
