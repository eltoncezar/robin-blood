package data;

public class CrudException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CrudException() {
		super("Erro gen�rico");
	}
	
	public CrudException(String message) {
		super(message);
	}
}
