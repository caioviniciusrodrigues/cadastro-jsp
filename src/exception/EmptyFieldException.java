package exception;

public class EmptyFieldException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmptyFieldException(String campo) {
		super(campo + " vazio!");
	}

}
