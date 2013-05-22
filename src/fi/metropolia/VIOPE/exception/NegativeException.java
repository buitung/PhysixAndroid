package fi.metropolia.VIOPE.exception;

public class NegativeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7995766141630136675L;
	
	public NegativeException(){
		super();
	}

	public NegativeException(String message){
		super(message);
	}
}
