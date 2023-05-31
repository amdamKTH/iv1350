package startup;

public class IllegalOrderParameterException extends RuntimeException{
	
	public IllegalOrderParameterException() {}
	
	public void errorMessage() {
		System.out.println("The first parameter has to be less than the second.");
	}
}
