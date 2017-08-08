package exceptions;

public class InvalidDiceRollRequest extends Exception {
	
	private static final long serialVersionUID = 8813581474461746472L;

	public InvalidDiceRollRequest(){
		super();
	}

	public InvalidDiceRollRequest(String message){
		super(message);
	}

	public InvalidDiceRollRequest(String message, Throwable cause){
		super(message, cause);
	}

	public InvalidDiceRollRequest(Throwable cause){
		super(cause);
	}
	
}