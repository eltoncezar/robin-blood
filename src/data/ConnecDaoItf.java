package data;

import java.util.List;


public interface ConnecDaoItf {
	public List<Autor> listAll() throws ConnectException;
	public void save(Autor autor) throws ConnectException;
	public void delete (String nome) throws ConnectException;
	public Autor select(String nome) throws ConnectException;

}
