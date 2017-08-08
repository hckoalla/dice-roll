package exceptions;

public class EmptyDiceRollRequest extends Exception {
	
	private static final long serialVersionUID = 8813581474461746472L;

	public EmptyDiceRollRequest(){
		super();
	}

	public EmptyDiceRollRequest(String message){
		super(message);
	}

	public EmptyDiceRollRequest(String message, Throwable cause){
		super(message, cause);
	}

	public EmptyDiceRollRequest(Throwable cause){
		super(cause);
	}
	
}