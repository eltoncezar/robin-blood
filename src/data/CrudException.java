package data;

public class CrudException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CrudException() {
		super("Erro genérico");
	}
	
	public CrudException(String message) {
		super(message);
	}
}
