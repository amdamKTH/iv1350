package se.kth.iv1350.retailStore.dbhandler;

/**
 * Thrown when database is not found. 
 * */
public class NoDatabaseFoundException extends RuntimeException{
	
	/**
	 * Instantiaties an empty error message. 
	 * */
	public NoDatabaseFoundException () {}
	
	/**
	 * Permits a masssege to be desplayed if the error messages is thrown. 
	 * */
	public NoDatabaseFoundException (String message) {
		super(message);
	}
	
	public void dispErrorMessage() {
		System.out.println("System is currently unavailable. Please contact support.");
	};
}
